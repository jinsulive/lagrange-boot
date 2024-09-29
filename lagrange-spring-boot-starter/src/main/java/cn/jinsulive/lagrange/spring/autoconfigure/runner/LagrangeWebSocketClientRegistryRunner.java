package cn.jinsulive.lagrange.spring.autoconfigure.runner;

import cn.hutool.core.collection.CollUtil;
import cn.jinsulive.lagrange.spring.autoconfigure.client.LagrangeBotWebSocketClient;
import cn.jinsulive.lagrange.spring.autoconfigure.config.LagrangeConfig;
import cn.jinsulive.lagrange.spring.autoconfigure.entity.Bot;
import cn.jinsulive.lagrange.spring.autoconfigure.handler.EventServiceHandler;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;

import javax.annotation.Nullable;
import java.net.URI;
import java.util.List;

/**
 * lagrange websocket client registry
 *
 * @author lxy
 * @since 2024年03月05日 14:50:25
 */
public class LagrangeWebSocketClientRegistryRunner implements ApplicationRunner, ApplicationContextAware, Ordered {

    private static final Logger log = LoggerFactory.getLogger(LagrangeWebSocketClientRegistryRunner.class);

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
        List<Bot> bots = lagrangeConfig.getBots();
        if (CollUtil.isEmpty(bots)) {
            log.warn("The bot configuration was not obtained");
            return;
        }
        for (Bot bot : bots) {
            registerBot(beanFactory, bot);
        }
    }

    private void registerBot(DefaultListableBeanFactory beanFactory, Bot bot) {
        URI serverUri = URI.create(bot.getWebSocketServer());
        LagrangeBotWebSocketClient.Config config = new LagrangeBotWebSocketClient.Config();
        config.setBotId(bot.getId());
        config.setServerUri(serverUri);
        config.setWebsocketToken(bot.getWebSocketToken());
        config.setTokenType(bot.getTokenType());
        config.setEventServiceHandler(eventServiceHandler);
        config.setOpenDebugLog(lagrangeConfig.isOpenDebugLog());
        LagrangeBotWebSocketClient lagrangeBotWebSocketClient = new LagrangeBotWebSocketClient(config);
        Class<LagrangeBotWebSocketClient> lagrangeBotWebSocketClientClass = LagrangeBotWebSocketClient.class;
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(lagrangeBotWebSocketClientClass,
                () -> lagrangeBotWebSocketClient).setPrimary(false).getBeanDefinition();
        log.debug("[websocket] 注册bot: {}, name: {}", bot.getId(), lagrangeBotWebSocketClientClass.getName() + "." + bot.getId());
        beanFactory.registerBeanDefinition(lagrangeBotWebSocketClientClass.getName() + "." + bot.getId(), beanDefinition);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
