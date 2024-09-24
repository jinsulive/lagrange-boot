package cn.jinsulive.lagrange.spring.autoconfigure.runner;

import cn.jinsulive.lagrange.spring.autoconfigure.client.LagrangeBotWebSocketClient;
import cn.jinsulive.lagrange.spring.autoconfigure.config.LagrangeConfig;
import cn.jinsulive.lagrange.spring.autoconfigure.handler.EventServiceHandler;
import jakarta.annotation.Resource;
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
        LagrangeBotWebSocketClient.Config config = new LagrangeBotWebSocketClient.Config();
        config.setServerUri(serverUri);
        config.setWebsocketToken(lagrangeConfig.getWebSocketToken());
        config.setTokenType(lagrangeConfig.getTokenType());
        config.setEventServiceHandler(eventServiceHandler);
        config.setOpenDebugLog(lagrangeConfig.isOpenDebugLog());
        LagrangeBotWebSocketClient lagrangeBotWebSocketClient = new LagrangeBotWebSocketClient(config);
        Class<LagrangeBotWebSocketClient> lagrangeBotWebSocketClientClass = LagrangeBotWebSocketClient.class;
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(lagrangeBotWebSocketClientClass,
                () -> lagrangeBotWebSocketClient).setPrimary(false).getBeanDefinition();
        beanFactory.registerBeanDefinition(lagrangeBotWebSocketClientClass.getName(), beanDefinition);
    }

}
