package com.jinsulive.lagrange.sdk.request.other;

import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.other.GetCsrfTokenResponse;

/**
 * @author lxy
 * @since 2024年09月11日 15:47:58
 */
public class GetCsrfTokenRequest extends AbstractRequest<GetCsrfTokenResponse> {
    @Override
    public String getServiceUrl() {
        return "get_csrf_token";
    }

    @Override
    public String getJsonParamString() {
        return "{}";
    }

    @Override
    public Class<GetCsrfTokenResponse> getResponseClass() {
        return GetCsrfTokenResponse.class;
    }
}
