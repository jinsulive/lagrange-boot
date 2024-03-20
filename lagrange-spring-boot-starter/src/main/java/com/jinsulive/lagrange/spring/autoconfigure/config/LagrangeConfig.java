package com.jinsulive.lagrange.spring.autoconfigure.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * lagrange config
 *
 * @author lxy
 * @since 2024年03月06日 11:29:52
 */
@Data
@ConfigurationProperties(prefix = "lagrange")
public class LagrangeConfig {

    private String webSocketServer;

    private String httpServer;

    private boolean openDebugLog = false;

    private boolean openMataEventLog = false;

}
