package com.jinsulive.lagrange.sdk.request.other;

import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.other.GetStatusResponse;

/**
 * 获取运行状态
 *
 * @author lxy
 * @since 2024年09月11日 16:10:53
 */
public class GetStatusRequest extends AbstractRequest<GetStatusResponse> {
    @Override
    public String getServiceUrl() {
        return "get_status";
    }

    @Override
    public String getJsonParamString() {
        return "{}";
    }

    @Override
    public Class<GetStatusResponse> getResponseClass() {
        return GetStatusResponse.class;
    }
}
