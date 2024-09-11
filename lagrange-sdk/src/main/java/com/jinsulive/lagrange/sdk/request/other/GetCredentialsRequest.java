package com.jinsulive.lagrange.sdk.request.other;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.other.GetCredentialsResponse;

/**
 * get_cookies 与 get_csrf_token的合并
 *
 * @author lxy
 * @since 2024年09月11日 15:51:53
 */
public class GetCredentialsRequest extends AbstractRequest<GetCredentialsResponse> {

    /**
     * 需要获取 cookies 的域名
     */
    private String domain;

    @Override
    public String getServiceUrl() {
        return "get_credentials";
    }

    @Override
    public String getJsonParamString() {
        return JSONUtil.createObj()
                .putOpt("domain", domain)
                .toString();
    }

    @Override
    public Class<GetCredentialsResponse> getResponseClass() {
        return GetCredentialsResponse.class;
    }
}
