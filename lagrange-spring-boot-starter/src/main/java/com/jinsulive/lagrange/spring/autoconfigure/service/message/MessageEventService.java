package com.jinsulive.lagrange.spring.autoconfigure.service.message;

import cn.hutool.core.lang.Assert;
import com.jinsulive.lagrange.core.annotation.ListenerInfo;
import com.jinsulive.lagrange.core.annotation.message.MessageListenerInfo;
import com.jinsulive.lagrange.core.constant.PostType;
import com.jinsulive.lagrange.core.event.BaseEvent;
import com.jinsulive.lagrange.core.event.message.FriendMessageEvent;
import com.jinsulive.lagrange.core.event.message.GroupMessageEvent;
import com.jinsulive.lagrange.core.event.message.MessageEvent;
import com.jinsulive.lagrange.core.util.ConvertUtil;
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
public class MessageEventService implements EventService {

    private static final Logger log = LoggerFactory.getLogger(MessageEventService.class);

    private final ExecutorService executorService = this.executorService();
    @Resource
    private LagrangeConfig lagrangeConfig;
    @Resource
    private MethodListenerContext methodListenerContext;
    @Resource
    private MessageEventMatcherService messageEventMatcherService;

    private ExecutorService executorService() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return new ThreadPoolExecutor(availableProcessors, availableProcessors,
                300L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(),
                new CustomizableThreadFactory("message-executor-"),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @Override
    public PostType postType() {
        return PostType.MESSAGE;
    }

    @Override
    public void handler(BaseEvent event) {
        MessageEvent messageEvent = (MessageEvent) event;
        LogUtil.debug(lagrangeConfig.isOpenDebugLog(), "[MessageEvent] 收到message消息: {}", messageEvent);
        executorService.execute(() -> {
            List<ListenerInfo> messageListenerInfos = methodListenerContext.getListenerInfos();
            messageListenerInfos.forEach(listenerInfo -> {
                if (listenerInfo instanceof MessageListenerInfo messageListenerInfo) {
                    boolean match = messageEventMatcherService.match(messageEvent, messageListenerInfo);
                    if (match) {
                        this.invoke(messageEvent, messageListenerInfo);
                    }
                }
            });
        });
    }

    private void invoke(MessageEvent messageEvent, MessageListenerInfo messageListenerInfo) {
        Method method = messageListenerInfo.getMethod();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Assert.isTrue(parameterTypes.length == 1, "{} should have only one parameter. but found {}.", messageListenerInfo.getName(), parameterTypes.length);
        Class<?> parameterType = parameterTypes[0];
        Class<?> declaringClass = method.getDeclaringClass();
        try {
            // 从spring中获取实例
            Object instance = SpringUtil.getBean(declaringClass);
            if (parameterType.isAssignableFrom(GroupMessageEvent.class)) {
                GroupMessageEvent groupMessageEvent = ConvertUtil.convertGroupMessageEvent(messageEvent);
                method.invoke(instance, groupMessageEvent);
            } else if (parameterType.isAssignableFrom(FriendMessageEvent.class)) {
                FriendMessageEvent friendMessageEvent = ConvertUtil.convertFriendMessageEvent(messageEvent);
                method.invoke(instance, friendMessageEvent);
            } else if (parameterType.isAssignableFrom(String.class)) {
                String eventString = ConvertUtil.convertMessageEventString(messageEvent);
                method.invoke(instance, eventString);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("[MessageEvent-Executor] 执行 {} 异常 error: {}", messageListenerInfo.getName(), e.getMessage(), e);
        }
    }

}
