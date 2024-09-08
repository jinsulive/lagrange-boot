package com.jinsulive.lagrange.spring.autoconfigure.service.notice;

import cn.hutool.core.lang.Assert;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.core.annotation.ListenerInfo;
import com.jinsulive.lagrange.core.annotation.notice.NoticeListenerInfo;
import com.jinsulive.lagrange.core.constant.PostType;
import com.jinsulive.lagrange.core.event.BaseEvent;
import com.jinsulive.lagrange.core.event.notice.NoticeEvent;
import com.jinsulive.lagrange.core.util.LogUtil;
import com.jinsulive.lagrange.spring.autoconfigure.config.LagrangeConfig;
import com.jinsulive.lagrange.spring.autoconfigure.entity.MethodListenerContext;
import com.jinsulive.lagrange.spring.autoconfigure.service.EventService;
import com.jinsulive.lagrange.spring.autoconfigure.util.SpringUtil;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lxy
 * @since 2024年03月06日 16:42:07
 */
public class NoticeEventService implements EventService {

    private static final Logger log = LoggerFactory.getLogger(NoticeEventService.class);

    private final ExecutorService executorService = this.executorService();

    @Autowired
    private NoticeEventMatcherService requestEventMatcherService;

    @Autowired
    private MethodListenerContext methodListenerContext;

    @Resource
    private LagrangeConfig lagrangeConfig;

    private ExecutorService executorService() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return new ThreadPoolExecutor(availableProcessors, availableProcessors,
                300L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(),
                new CustomizableThreadFactory("notice-executor-"),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @Override
    public PostType postType() {
        return PostType.NOTICE;
    }

    @Override
    public void handler(BaseEvent event) {
        NoticeEvent noticeEvent = (NoticeEvent) event;
        LogUtil.debug(lagrangeConfig.isOpenDebugLog(), "[NoticeEvent] 收到notice消息: {}", noticeEvent);
        executorService.execute(() -> {
            List<ListenerInfo> messageListenerInfos = methodListenerContext.getListenerInfos();
            messageListenerInfos.forEach(listenerInfo -> {
                if (listenerInfo instanceof NoticeListenerInfo noticeListenerInfo) {
                    boolean match = requestEventMatcherService.match(noticeEvent, noticeListenerInfo);
                    if (match) {
                        this.invoke(noticeEvent, noticeListenerInfo);
                    }
                }
            });
        });
    }

    private void invoke(NoticeEvent noticeEvent, NoticeListenerInfo noticeListenerInfo) {
        Method method = noticeListenerInfo.getMethod();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Assert.isTrue(parameterTypes.length == 1, "{} should have only one parameter. but found {}.", noticeListenerInfo.getName(), parameterTypes.length);
        Class<?> parameterType = parameterTypes[0];
        Class<?> declaringClass = method.getDeclaringClass();
        try {
            // 从spring中获取实例
            Object instance = SpringUtil.getBean(declaringClass);
            if (parameterType.isAssignableFrom(NoticeEvent.class)) {
                method.invoke(instance, noticeEvent);
            } else if (parameterType.isAssignableFrom(String.class)) {
                method.invoke(instance, JSONUtil.toJsonStr(noticeEvent));
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("[NoticeEvent-Executor] 执行 {} 异常 error: {}", noticeListenerInfo.getName(), e.getMessage(), e);
        }
    }
}
