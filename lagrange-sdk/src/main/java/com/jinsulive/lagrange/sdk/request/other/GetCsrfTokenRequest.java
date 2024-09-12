package com.jinsulive.lagrange.sdk.request.other;

import cn.hutool.http.Method;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.other.GetCsrfTokenResponse;

/**
 * 获取 csrf token
 *
 * @author lxy
 * @since 2024年09月11日 15:47:58
 */
public class GetCsrfTokenRequest extends AbstractRequest<GetCsrfTokenResponse> {

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public String getServiceUrl() {
        return "get_csrf_token";
    }

    @Override
    public Class<GetCsrfTokenResponse> getResponseClass() {
        return GetCsrfTokenResponse.class;
    }
}
