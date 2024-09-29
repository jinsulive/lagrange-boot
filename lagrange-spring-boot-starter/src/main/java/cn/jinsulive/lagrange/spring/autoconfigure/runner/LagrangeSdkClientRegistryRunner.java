package cn.jinsulive.lagrange.spring.autoconfigure.runner;

import cn.hutool.core.collection.CollUtil;
import cn.jinsulive.lagrange.sdk.AbstractLagrangeBotClient;
import cn.jinsulive.lagrange.sdk.LagrangeBotClient;
import cn.jinsulive.lagrange.spring.autoconfigure.config.LagrangeConfig;
import cn.jinsulive.lagrange.spring.autoconfigure.entity.Bot;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;

import javax.annotation.Nullable;
import java.util.List;

/**
 * lagrange sdk registry runner
 *
 * @author lxy
 * @since 2024年03月18日 15:02:03
 */
public class LagrangeSdkClientRegistryRunner implements ApplicationRunner, ApplicationContextAware, Ordered {

    private static final Logger log = LoggerFactory.getLogger(LagrangeSdkClientRegistryRunner.class);

    private ApplicationContext applicationContext;

    @Resource
    private LagrangeConfig lagrangeConfig;

    @Override
    public void setApplicationContext(@Nullable ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        List<Bot> bots = lagrangeConfig.getBots();
        if (CollUtil.isEmpty(bots)) {
            return;
        }
        for (Bot bot : bots) {
            registerSdkClient(beanFactory, bot);
        }
    }

    @SuppressWarnings("unchecked")
    private void registerSdkClient(DefaultListableBeanFactory beanFactory, Bot bot) throws Exception {
        Class<? extends LagrangeBotClient> aClass = (Class<? extends LagrangeBotClient>) Class.forName(lagrangeConfig.getLagrangeBotClient());
        String httpServer = bot.getHttpServer();
        if (httpServer == null) {
            throw new IllegalArgumentException("sendType has http. but lagrange httpServer is null");
        }
        AbstractLagrangeBotClient.Config config = new AbstractLagrangeBotClient.Config(
                bot.getId(), httpServer, bot.getHttpToken(), bot.getTokenType()
        );
        log.debug("[sdk] 注册bot: {}, name: {}", bot.getId(), LagrangeBotClient.class.getName() + "." + bot.getId());
        beanFactory.registerSingleton(LagrangeBotClient.class.getName() + "." + bot.getId(), aClass.getConstructor(AbstractLagrangeBotClient.Config.class).newInstance(config));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
