package com.jinsulive.lagrange.spring.autoconfigure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * lagrange config
 *
 * @author lxy
 * @since 2024年03月06日 11:29:52
 */
@ConfigurationProperties(prefix = "lagrange")
public class LagrangeConfig {

    private String webSocketServer;

    private String httpServer;

    private String webSocketToken = "";

    private String httpToken = "";

    private String tokenType = "Bearer ";

    private boolean openDebugLog = false;

    private boolean openMataEventLog = false;

    private String lagrangeBotClient = "com.jinsulive.lagrange.sdk.DefaultLagrangeBotClient";

    public LagrangeConfig() {
    }

    public String getWebSocketServer() {
        return webSocketServer;
    }

    public void setWebSocketServer(String webSocketServer) {
        this.webSocketServer = webSocketServer;
    }

    public String getHttpServer() {
        return httpServer;
    }

    public void setHttpServer(String httpServer) {
        this.httpServer = httpServer;
    }

    public String getWebSocketToken() {
        return webSocketToken;
    }

    public void setWebSocketToken(String webSocketToken) {
        this.webSocketToken = webSocketToken;
    }

    public String getHttpToken() {
        return httpToken;
    }

    public void setHttpToken(String httpToken) {
        this.httpToken = httpToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public boolean isOpenDebugLog() {
        return openDebugLog;
    }

    public void setOpenDebugLog(boolean openDebugLog) {
        this.openDebugLog = openDebugLog;
    }

    public boolean isOpenMataEventLog() {
        return openMataEventLog;
    }

    public void setOpenMataEventLog(boolean openMataEventLog) {
        this.openMataEventLog = openMataEventLog;
    }

    public String getLagrangeBotClient() {
        return lagrangeBotClient;
    }

    public void setLagrangeBotClient(String lagrangeBotClient) {
        this.lagrangeBotClient = lagrangeBotClient;
    }

}
