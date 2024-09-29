package cn.jinsulive.lagrange.spring.autoconfigure.service.message;

import cn.jinsulive.lagrange.core.annotation.ListenerInfo;
import cn.jinsulive.lagrange.core.annotation.message.MessageListenerInfo;
import cn.jinsulive.lagrange.core.constant.PostType;
import cn.jinsulive.lagrange.core.constant.message.MessageEventType;
import cn.jinsulive.lagrange.core.event.BaseEvent;
import cn.jinsulive.lagrange.core.event.message.FriendMessageEvent;
import cn.jinsulive.lagrange.core.event.message.GroupMessageEvent;
import cn.jinsulive.lagrange.core.event.message.MessageEvent;
import cn.jinsulive.lagrange.core.util.ConvertUtil;
import cn.jinsulive.lagrange.core.util.LogUtil;
import cn.jinsulive.lagrange.spring.autoconfigure.config.LagrangeConfig;
import cn.jinsulive.lagrange.spring.autoconfigure.entity.MethodListenerContext;
import cn.jinsulive.lagrange.spring.autoconfigure.service.EventService;
import cn.jinsulive.lagrange.spring.autoconfigure.util.SpringUtil;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

/**
 * @author lxy
 * @since 2024年03月06日 16:42:07
 */
public class MessageEventService implements EventService {

    private static final Logger log = LoggerFactory.getLogger(MessageEventService.class);

    @Resource(name = "lagrangeExecutorService")
    private ExecutorService executorService;

    @Resource
    private LagrangeConfig lagrangeConfig;
    @Resource
    private MethodListenerContext methodListenerContext;
    @Resource
    private MessageEventMatcherService messageEventMatcherService;

    @Override
    public PostType postType() {
        return PostType.MESSAGE;
    }

    @Override
    public void handler(BaseEvent event) {
        MessageEvent messageEvent = (MessageEvent) event;
        LogUtil.debug(lagrangeConfig.isOpenDebugLog(), "[MessageEvent.{}] 收到message消息: {}", messageEvent.getSelfId(), messageEvent);
        executorService.execute(() -> {
            List<ListenerInfo> messageListenerInfos = methodListenerContext.getListenerInfos();
            messageListenerInfos.forEach(listenerInfo -> {
                if (listenerInfo instanceof MessageListenerInfo messageListenerInfo) {
                    boolean match = messageEventMatcherService.match(messageEvent, messageListenerInfo);
                    if (match) {
                        messageEvent.setMatchType(messageListenerInfo.getMatchType());
                        messageEvent.setMatchValue(messageListenerInfo.getMatchValue());
                        this.invoke(messageEvent, messageListenerInfo);
                    }
                }
            });
        });
    }

    private void invoke(MessageEvent messageEvent, MessageListenerInfo messageListenerInfo) {
        Method method = messageListenerInfo.getMethod();
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length != 1) {
            log.error("[MessageEvent.invoke.{}] {} should have only one parameter. but found {}.", messageEvent.getSelfId(), messageListenerInfo.getName(), parameterTypes.length);
            return;
        }
        Class<?> parameterType = parameterTypes[0];
        Class<?> declaringClass = method.getDeclaringClass();
        try {
            // 从spring中获取实例
            Object instance = SpringUtil.getBean(declaringClass);
            if (Objects.equals(MessageEventType.GROUP, messageEvent.getMessageType()) && parameterType.isAssignableFrom(GroupMessageEvent.class)) {
                GroupMessageEvent groupMessageEvent = ConvertUtil.convertGroupMessageEvent(messageEvent);
                method.invoke(instance, groupMessageEvent);
            } else if (Objects.equals(MessageEventType.PRIVATE, messageEvent.getMessageType()) && parameterType.isAssignableFrom(FriendMessageEvent.class)) {
                FriendMessageEvent friendMessageEvent = ConvertUtil.convertFriendMessageEvent(messageEvent);
                method.invoke(instance, friendMessageEvent);
            } else if (parameterType.isAssignableFrom(String.class)) {
                String eventString = ConvertUtil.convertMessageEventString(messageEvent);
                method.invoke(instance, eventString);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("[MessageEvent.invoke.{}] 执行 {} 异常 error: {}", messageEvent.getSelfId(), messageListenerInfo.getName(), e.getMessage(), e);
        }
    }

}
