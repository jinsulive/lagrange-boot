package cn.jinsulive.lagrange.spring.autoconfigure.entity;

import cn.hutool.json.JSONUtil;

/**
 * @author lxy
 * @since 2024年09月29日 10:34:37
 */
public class Bot {

    private Long id;

    private String webSocketServer;

    private String httpServer;

    private String webSocketToken = "";

    private String httpToken = "";

    private String tokenType = "Bearer ";

    public Bot() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
