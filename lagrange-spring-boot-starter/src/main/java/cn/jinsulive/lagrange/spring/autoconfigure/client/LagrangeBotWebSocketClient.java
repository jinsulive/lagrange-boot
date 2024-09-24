package cn.jinsulive.lagrange.spring.autoconfigure.client;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.Header;
import cn.jinsulive.lagrange.core.event.BaseEvent;
import cn.jinsulive.lagrange.core.util.ConvertUtil;
import cn.jinsulive.lagrange.spring.autoconfigure.handler.EventServiceHandler;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;

import java.net.URI;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lxy
 * @since 2024年03月18日 16:05:03
 */
public class LagrangeBotWebSocketClient extends WebSocketClient implements DisposableBean {

    private static final Logger log = LoggerFactory.getLogger(LagrangeBotWebSocketClient.class);
    private final Config config;

    /**
     * Initial reconnect delay in seconds
     */
    private final long INITIAL_RECONNECT_DELAY = 1;
    private final long MAX_RECONNECT_ATTEMPTS = 10;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private long reconnectDelay = INITIAL_RECONNECT_DELAY;
    private int reconnectAttempts = 0;
    private Boolean reconnect = false;

    public LagrangeBotWebSocketClient(Config config) {
        super(config.getServerUri());
        this.config = config;
        String websocketToken = config.getWebsocketToken();
        if (StrUtil.isNotBlank(websocketToken)) {
            String authorization = config.getTokenType() + websocketToken;
            log.debug("[websocket] authorization header: {}", authorization);
            this.addHeader(Header.AUTHORIZATION.getValue(), authorization);
        }
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
            config.getEventServiceHandler().handle(baseEvent);
        } catch (Exception e) {
            log.error("[websocket] 消息处理出现异常 message: {}, e: {}", message, e.getMessage(), e);
        }
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        if (!reconnect) {
            log.warn("[websocket] 连接关闭 code: {}, reason: {}, remote: {}", code, reason, remote);
            reconnectWebSocket();
            reconnect = true;
        }
    }

    @Override
    public void onError(Exception ex) {
        log.error("[websocket] 连接异常 serverUri: {}, e: {}", super.getURI().getSchemeSpecificPart(), ex.getMessage(), ex);
    }

    private void reconnectWebSocket() {
        scheduler.schedule(() -> {
            try {
                if (reconnectAttempts >= MAX_RECONNECT_ATTEMPTS) {
                    log.error("[websocket] 达到最大重连次数: {} ，停止重连", MAX_RECONNECT_ATTEMPTS);
                    return;
                }
                reconnectAttempts++;
                boolean connect = reconnectBlocking();
                if (connect) {
                    log.info("[websocket] 重连成功，重试次数为:" + reconnectAttempts);
                    reconnectDelay = INITIAL_RECONNECT_DELAY;
                    reconnectAttempts = 0;
                    reconnect = false;
                } else {
                    reconnectDelay();
                }
            } catch (Exception e) {
                log.error("[websocket] 重连异常: {}", e.getMessage(), e);
                reconnectDelay();
            }
        }, reconnectDelay, TimeUnit.SECONDS);
    }

    private void reconnectDelay() {
        reconnectDelay = (long) Math.min((reconnectDelay * Math.pow(1.25, reconnectAttempts)), 30);
        log.info("[websocket]重连失败 已重试次数: {}, 下次重连延迟: {}", reconnectAttempts, reconnectDelay);
        reconnectWebSocket();
    }

    @Override
    public void destroy() throws Exception {
        this.closeBlocking();
        log.info("[websocket] 连接关闭");
    }

    public static class Config {

        private URI serverUri;

        private String websocketToken;

        private String tokenType;

        private EventServiceHandler eventServiceHandler;

        public Config() {
        }

        public URI getServerUri() {
            return serverUri;
        }

        public void setServerUri(URI serverUri) {
            this.serverUri = serverUri;
        }

        public String getWebsocketToken() {
            return websocketToken;
        }

        public void setWebsocketToken(String websocketToken) {
            this.websocketToken = websocketToken;
        }

        public String getTokenType() {
            return tokenType;
        }

        public void setTokenType(String tokenType) {
            this.tokenType = tokenType;
        }

        public EventServiceHandler getEventServiceHandler() {
            return eventServiceHandler;
        }

        public void setEventServiceHandler(EventServiceHandler eventServiceHandler) {
            this.eventServiceHandler = eventServiceHandler;
        }

    }

}
