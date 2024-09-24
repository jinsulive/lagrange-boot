package cn.jinsulive.lagrange.sdk.request.other;

import cn.hutool.http.Method;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.sdk.request.AbstractRequest;
import cn.jinsulive.lagrange.sdk.response.other.GetCookiesResponse;

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
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public String getServiceUrl() {
        return "get_cookies";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("domain", domain);
    }

    @Override
    public Class<GetCookiesResponse> getResponseClass() {
        return GetCookiesResponse.class;
    }
}
