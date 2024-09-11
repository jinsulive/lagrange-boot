package com.jinsulive.lagrange.sdk.request.info;

import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.info.LoginInfoResponse;

/**
 * 获取登录号信息
 *
 * @author lxy
 * @since 2024年03月21日 15:10:48
 */
public class QueryLoginInfoRequest extends AbstractRequest<LoginInfoResponse> {

    public QueryLoginInfoRequest() {
    }

    @Override
    public String getServiceUrl() {
        return "get_login_info";
    }

    @Override
    public String getJsonParamString() {
        return "{}";
    }

    @Override
    public Class<LoginInfoResponse> getResponseClass() {
        return LoginInfoResponse.class;
    }

}
