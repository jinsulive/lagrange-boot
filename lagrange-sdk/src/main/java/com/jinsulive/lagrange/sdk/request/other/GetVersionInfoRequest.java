package com.jinsulive.lagrange.sdk.request.other;

import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.other.GetVersionInfoResponse;

/**
 * 获取版本信息
 *
 * @author lxy
 * @since 2024年09月11日 16:21:12
 */
public class GetVersionInfoRequest extends AbstractRequest<GetVersionInfoResponse> {

    @Override
    public String getServiceUrl() {
        return "get_version_info";
    }

    @Override
    public Class<GetVersionInfoResponse> getResponseClass() {
        return GetVersionInfoResponse.class;
    }
}
