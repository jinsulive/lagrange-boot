package com.jinsulive.lagrange.sdk.request.other;

import cn.hutool.http.Method;
import cn.hutool.json.JSONObject;
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

    public GetCredentialsRequest() {
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public String getServiceUrl() {
        return "get_credentials";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("domain", domain);
    }

    @Override
    public Class<GetCredentialsResponse> getResponseClass() {
        return GetCredentialsResponse.class;
    }
}
