package com.jinsulive.lagrange.spring.autoconfigure.client;

import com.jinsulive.lagrange.core.event.BaseEvent;
import com.jinsulive.lagrange.core.util.ConvertUtil;
import com.jinsulive.lagrange.spring.autoconfigure.handler.EventServiceHandler;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author lxy
 * @since 2024年03月18日 16:05:03
 */
public class LagrangeBotWebSocketClient extends WebSocketClient {

    private static final Logger log = LoggerFactory.getLogger(LagrangeBotWebSocketClient.class);

    private final Integer reconnectInterval = 1000;
    private final Integer maxReconnectInterval = 30000;
    private final Double reconnectDecay = 1.5;
    private final Integer maxReconnectAttempts = 5000;
    private final EventServiceHandler eventServiceHandler;
    private Integer reconnectAttempts = 0;
    private Timer reconnectTimer;
    private volatile Boolean isReconnecting = false;
    private TimerTask reconnectTimerTask;

    public LagrangeBotWebSocketClient(URI serverUri, EventServiceHandler eventServiceHandler) {
        super(serverUri);
        this.eventServiceHandler = eventServiceHandler;
        this.connect();
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        log.info("[websocket] 建立连接");
    }

    @Override
    public void onMessage(String message) {
        try {
            BaseEvent baseEvent = ConvertUtil.convertMessage(message);
            if (Objects.isNull(baseEvent)) {
                log.warn("[websocket] 收到未知类型消息: {}", message);
                return;
            }
            eventServiceHandler.handle(baseEvent);
        } catch (Exception e) {
            log.error("[websocket] 消息处理出现异常: {}", e.getMessage(), e);
        }
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        if (!isReconnecting) {
            log.warn("[websocket] 连接关闭 code: {}, reason: {}, remote: {}", code, reason, remote);
            restartReconnectionTimer();
            isReconnecting = true;
        }
    }

    @Override
    public void onError(Exception ex) {
        log.error("[websocket] 连接异常: {}", ex.getMessage(), ex);
    }

    private void restartReconnectionTimer() {
        cancelReconnectionTimer();
        reconnectTimer = new Timer("reconnectTimer");
        reconnectTimerTask = new ReconnectTimerTask() {
            @Override
            public void run() {
                if (reconnectAttempts >= maxReconnectAttempts) {
                    cancelReconnectionTimer();
                    log.error("[websocket] 达到最大重连次数:" + maxReconnectAttempts + "，停止重连");
                }
                reconnectAttempts++;
                try {
                    boolean isOpen = reconnectBlocking();
                    if (isOpen) {
                        log.info("[websocket] 重连成功，重试次数为:" + reconnectAttempts);
                        cancelReconnectionTimer();
                        reconnectAttempts = 0;
                        isReconnecting = false;
                    } else {
                        log.warn("[websocket] 重连失败，重试次数为:" + reconnectAttempts);
                        double timeOuted = reconnectInterval * Math.pow(reconnectDecay, reconnectAttempts);
                        int timeout = Integer.parseInt(new DecimalFormat("0").format(timeOuted));
                        timeout = timeout > maxReconnectInterval ? maxReconnectInterval : timeout;
                        reSchedule(timeout);
                    }
                } catch (Exception e) {
                    log.error("[websocket] 重连异常: {}", e.getMessage(), e);
                }
            }
        };
        reconnectTimer.scheduleAtFixedRate(reconnectTimerTask, 0, reconnectInterval);
    }

    private void cancelReconnectionTimer() {
        if (reconnectTimer != null) {
            reconnectTimer.cancel();
            reconnectTimer = null;
        }
        if (reconnectTimerTask != null) {
            reconnectTimerTask.cancel();
            reconnectTimerTask = null;
        }
    }


}
