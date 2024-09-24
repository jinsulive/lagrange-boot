package cn.jinsulive.lagrange.sdk.request.expand;

import cn.hutool.http.Method;
import cn.jinsulive.lagrange.sdk.request.AbstractRequest;
import cn.jinsulive.lagrange.sdk.response.expand.FetchCustomFaceResponse;

/**
 * 获取收藏表情
 *
 * @author lxy
 * @since 2024年09月12日 14:16:39
 */
public class FetchCustomFaceRequest extends AbstractRequest<FetchCustomFaceResponse> {

    public FetchCustomFaceRequest() {
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public String getServiceUrl() {
        return "fetch_custom_face";
    }

    @Override
    public Class<FetchCustomFaceResponse> getResponseClass() {
        return FetchCustomFaceResponse.class;
    }
}
