package com.jinsulive.lagrange.sdk.request.other;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.other.GetCookiesResponse;

/**
 * @author lxy
 * @since 2024年09月11日 15:43:47
 */
public class GetCookiesRequest extends AbstractRequest<GetCookiesResponse> {

    /**
     * 需要获取 cookies 的域名
     */
    private String domain;

    public GetCookiesRequest() {
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String getServiceUrl() {
        return "get_cookies";
    }

    @Override
    public String getJsonParamString() {
        return JSONUtil.createObj()
                .putOpt("domain", domain)
                .toString();
    }

    @Override
    public Class<GetCookiesResponse> getResponseClass() {
        return GetCookiesResponse.class;
    }
}
