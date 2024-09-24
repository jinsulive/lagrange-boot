package cn.jinsulive.lagrange.sdk.request.group;

import cn.hutool.http.Method;
import cn.jinsulive.lagrange.sdk.request.AbstractRequest;
import cn.jinsulive.lagrange.sdk.response.group.GroupListResponse;

/**
 * 获取群列表
 *
 * @author lxy
 * @since 2024年09月11日 15:20:34
 */
public class QueryGroupListRequest extends AbstractRequest<GroupListResponse> {

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public String getServiceUrl() {
        return "get_group_list";
    }

    @Override
    public Class<GroupListResponse> getResponseClass() {
        return GroupListResponse.class;
    }
}
