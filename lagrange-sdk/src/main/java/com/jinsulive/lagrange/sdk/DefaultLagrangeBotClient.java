package com.jinsulive.lagrange.sdk;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.*;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.AbstractResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

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
        boolean isNotRealizedYet = request.getClass().isAnnotationPresent(LagrangeNotRealizedYet.class);
        if (isNotRealizedYet) {
            throw new IllegalArgumentException("\"" + request.getServiceUrl() +
                    "\" not realize yet in lagrange, may be realize in the future.");
        }
        String serviceUrl = request.getServiceUrl();
        JSONObject paramJson = request.getParamJson();
        Method method = request.getMethod();
        HttpRequest postRequest = this.buildRequest(serviceUrl, method, paramJson);
        HttpResponse execute = postRequest.execute();
        String response = execute.body();
        execute.close();
        if (StrUtil.isBlank(response)) {
            log.error("[DefaultLagrangeBotClient] response is blank. serviceUrl: {}, paramJson: {}", serviceUrl, paramJson);
            return null;
        }
        log.debug("[DefaultLagrangeBotClient] response: {}", response);
        return JSONUtil.toBean(response, request.getResponseClass());
    }

    private HttpRequest buildRequest(String serviceUrl, Method method, JSONObject paramJson) {
        String url = this.buildUrl(serviceUrl);
        HttpRequest httpRequest;
        if (method == Method.POST) {
            httpRequest = HttpRequest.post(url);
            httpRequest.header(Header.CONTENT_TYPE, ContentType.JSON.toString());
            httpRequest.body(paramJson.toString());
            log.debug("[DefaultLagrangeBotClient] [POST] url: {}, paramJson: {}", url, paramJson);
        } else if (method == Method.GET) {
            String finalUrl = HttpUtil.urlWithForm(url, paramJson, StandardCharsets.UTF_8, false);
            httpRequest = HttpRequest.get(finalUrl);
            log.debug("[DefaultLagrangeBotClient] [GET] finalUrl: {}", finalUrl);
        } else {
            throw new UnsupportedOperationException("unsupported http method: " + method + ". serviceUrl: " + serviceUrl);
        }
        String httpToken = config.getHttpToken();
        if (StrUtil.isNotBlank(httpToken)) {
            httpRequest.header(Header.AUTHORIZATION, config.getTokenType() + httpToken);
        }
        return httpRequest;
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
