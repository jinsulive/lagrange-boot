package cn.jinsulive.lagrange.sdk;

import cn.hutool.core.util.StrUtil;

/**
 * lagrange bot 客户端抽象类
 *
 * @author lxy
 * @since 2024年09月12日 11:05:13
 */
public abstract class AbstractLagrangeBotClient implements LagrangeBotClient {

    protected final Config config;

    public AbstractLagrangeBotClient(Config config) {
        if (StrUtil.isBlankOrUndefined(config.getServerUrl())) {
            throw new IllegalArgumentException("lagrange bot[ ID: " + config.getBotId() + " ] server url can not be blank or undefined");
        }
        this.config = config;
    }

    public static class Config {

        public Long botId;
        private String serverUrl;
        private String httpToken;
        private String tokenType;

        public Config(Long botId, String serverUrl, String httpToken, String tokenType) {
            this.botId = botId;
            this.serverUrl = serverUrl;
            this.httpToken = httpToken;
            this.tokenType = tokenType;
        }

        public Long getBotId() {
            return botId;
        }

        public void setBotId(Long botId) {
            this.botId = botId;
        }

        public String getServerUrl() {
            return serverUrl;
        }

        public void setServerUrl(String serverUrl) {
            this.serverUrl = serverUrl;
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

}
