package cn.jinsulive.lagrange.sdk.request.info;

import cn.hutool.http.Method;
import cn.jinsulive.lagrange.sdk.request.AbstractRequest;
import cn.jinsulive.lagrange.sdk.response.info.LoginInfoResponse;

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
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public String getServiceUrl() {
        return "get_login_info";
    }

    @Override
    public Class<LoginInfoResponse> getResponseClass() {
        return LoginInfoResponse.class;
    }

}
