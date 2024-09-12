package com.jinsulive.lagrange.sdk;

/**
 * @author lxy
 * @since 2024年09月12日 11:03:46
 */
public class ClientConfig {

    private String httpServer;
    private String httpToken;
    private String tokenType;

    public ClientConfig(String httpServer, String httpToken, String tokenType) {
        this.httpServer = httpServer;
        this.httpToken = httpToken;
        this.tokenType = tokenType;
    }

    public String getHttpServer() {
        return httpServer;
    }

    public void setHttpServer(String httpServer) {
        this.httpServer = httpServer;
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

}
