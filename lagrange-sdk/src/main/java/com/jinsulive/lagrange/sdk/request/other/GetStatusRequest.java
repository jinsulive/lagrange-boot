package com.jinsulive.lagrange.sdk.request.other;

import cn.hutool.http.Method;
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
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public String getServiceUrl() {
        return "get_status";
    }

    @Override
    public Class<GetStatusResponse> getResponseClass() {
        return GetStatusResponse.class;
    }
}
