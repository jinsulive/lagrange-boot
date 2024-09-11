package com.jinsulive.lagrange.sdk.request.other;

import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.EmptyResponse;

/**
 * 清理缓存
 *
 * @author lxy
 * @since 2024年09月11日 16:27:16
 */
public class CleanCacheRequest extends AbstractRequest<EmptyResponse> {
    @Override
    public String getServiceUrl() {
        return "clean_cache";
    }

    @Override
    public String getJsonParamString() {
        return "{}";
    }

    @Override
    public Class<EmptyResponse> getResponseClass() {
        return EmptyResponse.class;
    }
}
