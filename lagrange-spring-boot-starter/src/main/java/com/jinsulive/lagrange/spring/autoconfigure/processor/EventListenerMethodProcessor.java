package com.jinsulive.lagrange.spring.autoconfigure.processor;

import cn.hutool.core.lang.Assert;
import com.jinsulive.lagrange.core.annotation.message.MessageListener;
import com.jinsulive.lagrange.core.annotation.message.MessageListenerInfo;
import com.jinsulive.lagrange.core.event.message.FriendMessageEvent;
import com.jinsulive.lagrange.core.event.message.GroupMessageEvent;
import com.jinsulive.lagrange.spring.autoconfigure.entity.MethodListenerContext;
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
        List<MessageListenerInfo> messageListenerInfos = new ArrayList<>();
        while (beanNamesIterator.hasNext()) {
            String beanName = beanNamesIterator.next();
            if (!ScopedProxyUtils.isScopedTarget(beanName)) {
                Class<?> type = beanFactory.getType(beanName);
                if (Objects.nonNull(type)) {
                    this.processType(type, messageListenerInfos);
                }
            }
        }
        this.registerMethodListenerContext(messageListenerInfos);
    }

    private void processType(Class<?> type, List<MessageListenerInfo> messageListenerInfos) {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MessageListener.class)) {
                if (!this.isAssignableMethodParamType(method)) {
                    continue;
                }
                MessageListener messageListener = method.getAnnotation(MessageListener.class);
                MessageListenerInfo messageListenerInfo = this.convertMessageListenerInfo(type, method, messageListener);
                messageListenerInfos.add(messageListenerInfo);
            }
        }
    }

    private void registerMethodListenerContext(List<MessageListenerInfo> messageListenerInfos) {
        String beanName = MethodListenerContext.class.getName();
        BeanDefinition beanDefinition = resolveToBeanDefinition(() ->
                MethodListenerContext.builder()
                        .messageListenerInfos(messageListenerInfos)
                        .build());
        registry.registerBeanDefinition(beanName, beanDefinition);
    }

    private boolean isAssignableMethodParamType(Method method) {
        Class<?> type = method.getDeclaringClass();
        String methodName = type.getName() + "." + method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Assert.isTrue(parameterTypes.length == 1, "{} should have only one parameter. but found {}.", methodName, parameterTypes.length);
        Class<?> parameterType = parameterTypes[0];
        boolean assignableMethodParamType = GroupMessageEvent.class.isAssignableFrom(parameterType) ||
                FriendMessageEvent.class.isAssignableFrom(parameterType) ||
                String.class.isAssignableFrom(parameterType);
        if (!assignableMethodParamType) {
            log.warn("{} should be assignable to [GroupMessageEvent, FriendMessageEvent, String]. but found {}", methodName, parameterType.getName());
        }
        return assignableMethodParamType;
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

    private BeanDefinition resolveToBeanDefinition(Supplier<MethodListenerContext> instanceSupplier) {
        return BeanDefinitionBuilder.genericBeanDefinition(MethodListenerContext.class, instanceSupplier)
                .setPrimary(false).getBeanDefinition();
    }

}