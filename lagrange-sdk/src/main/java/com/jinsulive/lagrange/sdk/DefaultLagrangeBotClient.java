package com.jinsulive.lagrange.sdk;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.AbstractResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lxy
 * @since 2024年03月15日 10:52:39
 */
public class DefaultLagrangeBotClient extends AbstractLagrangeBotClient {

    private static final Logger log = LoggerFactory.getLogger(DefaultLagrangeBotClient.class);

    private final Config config;

    public DefaultLagrangeBotClient(Config config) {
        super(config);
        this.config = config;
    }

    @Override
    public <T extends AbstractResponse> T execute(AbstractRequest<T> request) throws Exception {
        String url = this.buildUrl(request.getServiceUrl());
        String jsonParamString = request.getJsonParamString();
        HttpRequest postRequest = this.buildPostRequest(url, jsonParamString);
        HttpResponse execute = postRequest.execute();
        String response = execute.body();
        execute.close();
        if (StrUtil.isBlank(response)) {
            log.error("DefaultLagrangeBotClient: response is blank. serviceUrl: {}, body: {}", request.getServiceUrl(), jsonParamString);
            return null;
        }
        return JSONUtil.toBean(response, request.getResponseClass());
    }

    private HttpRequest buildPostRequest(String url, String body) {
        HttpRequest request = HttpRequest.post(url)
                .header(Header.CONTENT_TYPE, ContentType.JSON.toString());
        String httpToken = config.getHttpToken();
        if (StrUtil.isNotBlank(httpToken)) {
            request.header(Header.AUTHORIZATION, config.getTokenType() + httpToken);
        }
        return request.body(body);
    }

    private String buildUrl(String serviceUrl) {
        String serverUrl = config.getServerUrl();
        if (serverUrl.endsWith("/") && serviceUrl.startsWith("/")) {
            return serverUrl + serviceUrl.substring(1);
        }
        if (!serverUrl.endsWith("/") && !serviceUrl.startsWith("/")) {
            return serverUrl + "/" + serviceUrl;
        }
        return serverUrl + serviceUrl;
    }


}
