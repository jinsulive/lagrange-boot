package cn.jinsulive.lagrange.spring.autoconfigure.processor;

import cn.hutool.core.lang.Assert;
import cn.jinsulive.lagrange.core.annotation.ListenerInfo;
import cn.jinsulive.lagrange.core.annotation.message.MessageListener;
import cn.jinsulive.lagrange.core.annotation.message.MessageListenerInfo;
import cn.jinsulive.lagrange.core.annotation.notice.NoticeListener;
import cn.jinsulive.lagrange.core.annotation.notice.NoticeListenerInfo;
import cn.jinsulive.lagrange.core.annotation.request.RequestListener;
import cn.jinsulive.lagrange.core.annotation.request.RequestListenerInfo;
import cn.jinsulive.lagrange.core.event.message.FriendMessageEvent;
import cn.jinsulive.lagrange.core.event.message.GroupMessageEvent;
import cn.jinsulive.lagrange.core.event.notice.NoticeEvent;
import cn.jinsulive.lagrange.core.event.request.RequestEvent;
import cn.jinsulive.lagrange.spring.autoconfigure.entity.MethodListenerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;

import javax.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 监听器注册处理器
 *
 * @author lxy
 * @since 2024年03月08日 16:45:22
 */
public class EventListenerMethodProcessor extends ConfigurationClassPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(EventListenerMethodProcessor.class);

    private BeanDefinitionRegistry registry;

    @Override
    public void postProcessBeanDefinitionRegistry(@Nullable BeanDefinitionRegistry registry) throws BeansException {
        this.registry = registry;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        Iterator<String> beanNamesIterator = beanFactory.getBeanNamesIterator();
        List<ListenerInfo> listenerInfos = new ArrayList<>();
        while (beanNamesIterator.hasNext()) {
            String beanName = beanNamesIterator.next();
            if (!ScopedProxyUtils.isScopedTarget(beanName)) {
                Class<?> type = beanFactory.getType(beanName);
                if (Objects.nonNull(type)) {
                    this.processType(type, listenerInfos);
                }
            }
        }
        this.registerMethodListenerContext(listenerInfos);
    }

    private void processType(Class<?> type, List<ListenerInfo> listenerInfos) {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MessageListener.class)) {
                if (this.isNotAssignableMethodParamType(method, GroupMessageEvent.class, FriendMessageEvent.class, String.class)) {
                    continue;
                }
                MessageListener messageListener = method.getAnnotation(MessageListener.class);
                MessageListenerInfo messageListenerInfo = this.convertMessageListenerInfo(type, method, messageListener);
                listenerInfos.add(messageListenerInfo);
            } else if (method.isAnnotationPresent(NoticeListener.class)) {
                if (this.isNotAssignableMethodParamType(method, NoticeEvent.class, String.class)) {
                    continue;
                }
                NoticeListener noticeListener = method.getAnnotation(NoticeListener.class);
                NoticeListenerInfo noticeListenerInfo = this.convertNoticeListenerInfo(type, method, noticeListener);
                listenerInfos.add(noticeListenerInfo);
            } else if (method.isAnnotationPresent(RequestListener.class)) {
                if (this.isNotAssignableMethodParamType(method, RequestEvent.class, String.class)) {
                    continue;
                }
                RequestListener requestListener = method.getAnnotation(RequestListener.class);
                RequestListenerInfo requestListenerInfo = this.convertRequestListenerInfo(type, method, requestListener);
                listenerInfos.add(requestListenerInfo);
            }
        }
    }

    private void registerMethodListenerContext(List<ListenerInfo> listenerInfos) {
        String beanName = MethodListenerContext.class.getName();
        BeanDefinition beanDefinition = resolveToBeanDefinition(() ->
                MethodListenerContext.builder()
                        .listenerInfos(listenerInfos)
                        .build());
        registry.registerBeanDefinition(beanName, beanDefinition);
    }

    private boolean isNotAssignableMethodParamType(Method method, Class<?>... assignableTypes) {
        Class<?> type = method.getDeclaringClass();
        String methodName = type.getName() + "." + method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Assert.isTrue(parameterTypes.length == 1, "{} should have only one parameter. but found {}.", methodName, parameterTypes.length);
        Class<?> parameterType = parameterTypes[0];
        boolean assignableMethodParamType = false;
        for (Class<?> assignableType : assignableTypes) {
            if (parameterType.isAssignableFrom(assignableType)) {
                assignableMethodParamType = true;
                break;
            }
        }
        if (!assignableMethodParamType) {
            String assignableTypesStr = Arrays.stream(assignableTypes).map(Class::getName).collect(Collectors.joining(","));
            log.warn("{} should be assignable to [ {} ]. but found {}", assignableTypesStr, methodName, parameterType.getName());
        }
        return !assignableMethodParamType;
    }

    private MessageListenerInfo convertMessageListenerInfo(Class<?> type, Method method, MessageListener messageListener) {
        return MessageListenerInfo.builder()
                .name(type.getName() + "." + method.getName())
                .contentTrim(messageListener.contentTrim())
                .matchType(messageListener.match().matchType())
                .matchValue(messageListener.match().value())
                .bots(Arrays.asList(messageListener.filter().bots()))
                .groups(Arrays.asList(messageListener.filter().groups()))
                .authors(Arrays.asList(messageListener.filter().authors()))
                .atBot(messageListener.filter().atBot())
                .method(method)
                .build();
    }

    private NoticeListenerInfo convertNoticeListenerInfo(Class<?> type, Method method, NoticeListener noticeListener) {
        return NoticeListenerInfo.builder()
                .name(type.getName() + "." + method.getName())
                .noticeType(noticeListener.match().noticeType())
                .honorType(noticeListener.match().honorType())
                .subType(noticeListener.match().subType())
                .groups(Arrays.asList(noticeListener.filter().groups()))
                .method(method)
                .build();
    }

    private RequestListenerInfo convertRequestListenerInfo(Class<?> type, Method method, RequestListener requestListener) {
        return RequestListenerInfo.builder()
                .name(type.getName() + "." + method.getName())
                .requestType(requestListener.match().requestType())
                .subType(requestListener.match().subType())
                .method(method)
                .build();
    }

    private BeanDefinition resolveToBeanDefinition(Supplier<MethodListenerContext> instanceSupplier) {
        return BeanDefinitionBuilder.genericBeanDefinition(MethodListenerContext.class, instanceSupplier)
                .setPrimary(false).getBeanDefinition();
    }

}