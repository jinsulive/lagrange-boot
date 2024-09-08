package com.jinsulive.lagrange.spring.autoconfigure.service.request;

import cn.hutool.core.lang.Assert;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.core.annotation.ListenerInfo;
import com.jinsulive.lagrange.core.annotation.request.RequestListenerInfo;
import com.jinsulive.lagrange.core.constant.PostType;
import com.jinsulive.lagrange.core.event.BaseEvent;
import com.jinsulive.lagrange.core.event.request.RequestEvent;
import com.jinsulive.lagrange.core.util.LogUtil;
import com.jinsulive.lagrange.spring.autoconfigure.config.LagrangeConfig;
import com.jinsulive.lagrange.spring.autoconfigure.entity.MethodListenerContext;
import com.jinsulive.lagrange.spring.autoconfigure.service.EventService;
import com.jinsulive.lagrange.spring.autoconfigure.util.SpringUtil;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class RequestEventService implements EventService {

    private static final Logger log = LoggerFactory.getLogger(RequestEventService.class);

    private final ExecutorService executorService = this.executorService();

    @Resource
    private LagrangeConfig lagrangeConfig;

    @Resource
    private MethodListenerContext methodListenerContext;
    @Resource
    private RequestEventMatcherService requestEventMatcherService;

    @Override
    public PostType postType() {
        return PostType.REQUEST;
    }

    private ExecutorService executorService() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return new ThreadPoolExecutor(availableProcessors, availableProcessors,
                300L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(),
                new CustomizableThreadFactory("request-executor-"),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @Override
    public void handler(BaseEvent event) {
        RequestEvent requestEvent = (RequestEvent) event;
        LogUtil.debug(lagrangeConfig.isOpenDebugLog(), "[RequestEvent] 收到request消息: {}", requestEvent);
        executorService.execute(() -> {
            List<ListenerInfo> messageListenerInfos = methodListenerContext.getListenerInfos();
            messageListenerInfos.forEach(listenerInfo -> {
                if (listenerInfo instanceof RequestListenerInfo requestListenerInfo) {
                    boolean match = requestEventMatcherService.match(requestEvent, requestListenerInfo);
                    if (match) {
                        this.invoke(requestEvent, requestListenerInfo);
                    }
                }
            });
        });
    }

    private void invoke(RequestEvent requestEvent, RequestListenerInfo requestListenerInfo) {
        Method method = requestListenerInfo.getMethod();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Assert.isTrue(parameterTypes.length == 1, "{} should have only one parameter. but found {}.", requestListenerInfo.getName(), parameterTypes.length);
        Class<?> parameterType = parameterTypes[0];
        Class<?> declaringClass = method.getDeclaringClass();
        try {
            // 从spring中获取实例
            Object instance = SpringUtil.getBean(declaringClass);
            if (parameterType.isAssignableFrom(RequestEvent.class)) {
                method.invoke(instance, requestEvent);
            } else if (parameterType.isAssignableFrom(String.class)) {
                method.invoke(instance, JSONUtil.toJsonStr(requestEvent));
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("[RequestEvent-Executor] 执行 {} 异常 error: {}", requestListenerInfo.getName(), e.getMessage(), e);
        }
    }

}
