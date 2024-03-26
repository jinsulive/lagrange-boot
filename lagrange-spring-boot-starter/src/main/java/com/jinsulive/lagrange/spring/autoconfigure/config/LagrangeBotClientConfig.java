package com.jinsulive.lagrange.spring.autoconfigure.config;

import com.jinsulive.lagrange.sdk.DefaultLagrangeBotClient;
import com.jinsulive.lagrange.sdk.LagrangeBotClient;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;

/**
 * lagrange bot http client config
 *
 * @author lxy
 * @since 2024年03月18日 15:02:03
 */
public class LagrangeBotClientConfig {

    @Resource
    private LagrangeConfig lagrangeConfig;

    public LagrangeBotClientConfig() {
    }

    @Bean
    public LagrangeBotClient lagrangeBotClient() {
        String httpServer = lagrangeConfig.getHttpServer();
        if (httpServer == null) {
            throw new IllegalArgumentException("sendType has http. but lagrange httpServer is null");
        }
        return new DefaultLagrangeBotClient(httpServer);
    }

}
