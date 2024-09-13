package com.jinsulive.lagrange.sdk.request.other;

import cn.hutool.http.Method;
import com.jinsulive.lagrange.sdk.LagrangeNotRealizedYet;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.EmptyResponse;

/**
 * 清理缓存
 *
 * @author lxy
 * @since 2024年09月11日 16:27:16
 */
@LagrangeNotRealizedYet
public class CleanCacheRequest extends AbstractRequest<EmptyResponse> {

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public String getServiceUrl() {
        return "clean_cache";
    }

    @Override
    public Class<EmptyResponse> getResponseClass() {
        return EmptyResponse.class;
    }
}
