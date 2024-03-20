package com.jinsulive.lagrange.sdk;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.LagrangeBotRequest;
import com.jinsulive.lagrange.sdk.response.AbstractResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lxy
 * @since 2024年03月15日 10:52:39
 */
@Slf4j
public class DefaultLagrangeBotClient implements LagrangeBotClient {

    private final String serverUrl;

    public DefaultLagrangeBotClient(String serverUrl) {
        if (StrUtil.isBlankOrUndefined(serverUrl)) {
            throw new IllegalArgumentException("lagrange bot server url can not be blank or undefined");
        }
        this.serverUrl = serverUrl;
    }

    @Override
    public <T extends AbstractResponse> T execute(LagrangeBotRequest<T> request) throws Exception {
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
        return HttpRequest.post(url)
                .header(Header.CONTENT_TYPE, ContentType.JSON.toString())
                .body(body);
    }

    private String buildUrl(String serviceUrl) {
        if (serverUrl.endsWith("/") && serviceUrl.startsWith("/")) {
            return serverUrl + serviceUrl.substring(1);
        }
        if (!serverUrl.endsWith("/") && !serviceUrl.startsWith("/")) {
            return serverUrl + "/" + serviceUrl;
        }
        return serverUrl + serviceUrl;
    }


}
