package cn.jinsulive.lagrange.spring.autoconfigure;

import cn.jinsulive.lagrange.spring.autoconfigure.config.LagrangeConfig;
import cn.jinsulive.lagrange.spring.autoconfigure.handler.EventServiceHandler;
import cn.jinsulive.lagrange.spring.autoconfigure.processor.EventListenerMethodProcessor;
import cn.jinsulive.lagrange.spring.autoconfigure.runner.LagrangeClientRegistryRunner;
import cn.jinsulive.lagrange.spring.autoconfigure.service.EventService;
import cn.jinsulive.lagrange.spring.autoconfigure.service.mata.MataEventService;
import cn.jinsulive.lagrange.spring.autoconfigure.service.message.MessageEventMatcherService;
import cn.jinsulive.lagrange.spring.autoconfigure.service.message.MessageEventService;
import cn.jinsulive.lagrange.spring.autoconfigure.service.message.impl.MessageEventMatcherServiceImpl;
import cn.jinsulive.lagrange.spring.autoconfigure.service.notice.NoticeEventMatcherService;
import cn.jinsulive.lagrange.spring.autoconfigure.service.notice.NoticeEventService;
import cn.jinsulive.lagrange.spring.autoconfigure.service.notice.impl.NoticeEventMatcherServiceImpl;
import cn.jinsulive.lagrange.spring.autoconfigure.service.request.RequestEventMatcherService;
import cn.jinsulive.lagrange.spring.autoconfigure.service.request.RequestEventService;
import cn.jinsulive.lagrange.spring.autoconfigure.service.request.impl.RequestEventMatcherServiceImpl;
import cn.jinsulive.lagrange.spring.autoconfigure.util.SpringUtil;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lxy
 * @since 2024年03月18日 14:04:11
 */
@AutoConfiguration
@EnableConfigurationProperties(LagrangeConfig.class)
public class LagrangeBotAutoConfiguration {

    @Bean("springUtil")
    @ConditionalOnMissingBean
    public SpringUtil springUtil() {
        return new SpringUtil();
    }

    @Bean("messageEventService")
    @ConditionalOnMissingBean
    public MessageEventService messageEventService() {
        return new MessageEventService();
    }

    @Bean("mataEventService")
    @ConditionalOnMissingBean
    public MataEventService mataEventService() {
        return new MataEventService();
    }

    @Bean("noticeEventService")
    @ConditionalOnMissingBean
    public NoticeEventService noticeEventService() {
        return new NoticeEventService();
    }

    @Bean("requestEventService")
    @ConditionalOnMissingBean
    public RequestEventService requestEventService() {
        return new RequestEventService();
    }

    @Bean("messageEventMatcherService")
    @ConditionalOnMissingBean
    public MessageEventMatcherService messageEventMatcherService() {
        return new MessageEventMatcherServiceImpl();
    }

    @Bean("noticeEventMatcherService")
    @ConditionalOnMissingBean
    public NoticeEventMatcherService noticeEventMatcherService() {
        return new NoticeEventMatcherServiceImpl();
    }

    @Bean("requestEventMatcherService")
    @ConditionalOnMissingBean
    public RequestEventMatcherService requestEventMatcherService() {
        return new RequestEventMatcherServiceImpl();
    }

    @Bean("eventServiceHandler")
    @ConditionalOnBean({MessageEventService.class, MataEventService.class, NoticeEventService.class, RequestEventService.class})
    @ConditionalOnMissingBean
    public EventServiceHandler eventServiceHandler(List<EventService> eventServices) {
        return new EventServiceHandler(eventServices);
    }

    @Bean("eventListenerMethodProcessor")
    @ConditionalOnBean(EventServiceHandler.class)
    @ConditionalOnMissingBean
    public EventListenerMethodProcessor eventListenerMethodProcessor() {
        return new EventListenerMethodProcessor();
    }

    @Bean("lagrangeClientRegistryRunner")
    @ConditionalOnMissingBean
    public LagrangeClientRegistryRunner lagrangeClientRegistryRunner() {
        return new LagrangeClientRegistryRunner();
    }

    @Bean("lagrangeExecutorService")
    @ConditionalOnMissingBean
    public ExecutorService lagrangeExecutorService() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return new ThreadPoolExecutor(availableProcessors, availableProcessors,
                300L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(),
                new CustomizableThreadFactory("lagrange-executor-"),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

}
