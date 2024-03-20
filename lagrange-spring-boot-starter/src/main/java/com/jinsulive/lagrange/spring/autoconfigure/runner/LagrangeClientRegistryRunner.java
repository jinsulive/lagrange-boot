package com.jinsulive.lagrange.spring.autoconfigure.runner;

import com.jinsulive.lagrange.spring.autoconfigure.client.LagrangeBotWebSocketClient;
import com.jinsulive.lagrange.spring.autoconfigure.config.LagrangeConfig;
import com.jinsulive.lagrange.spring.autoconfigure.handler.EventServiceHandler;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.Nullable;
import java.net.URI;

/**
 * lagrange client registry
 *
 * @author lxy
 * @since 2024年03月05日 14:50:25
 */
@Slf4j
public class LagrangeClientRegistryRunner implements ApplicationRunner, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Resource
    private LagrangeConfig lagrangeConfig;

    @Resource
    private EventServiceHandler eventServiceHandler;

    @Override
    public void setApplicationContext(@Nullable ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        URI serverUri = URI.create(lagrangeConfig.getWebSocketServer());
        LagrangeBotWebSocketClient lagrangeBotWebSocketClient = new LagrangeBotWebSocketClient(serverUri, eventServiceHandler);
        Class<LagrangeBotWebSocketClient> lagrangeBotWebSocketClientClass = LagrangeBotWebSocketClient.class;
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(lagrangeBotWebSocketClientClass,
                () -> lagrangeBotWebSocketClient).setPrimary(false).getBeanDefinition();
        beanFactory.registerBeanDefinition(lagrangeBotWebSocketClientClass.getName(), beanDefinition);
    }

}
