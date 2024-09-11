package com.jinsulive.lagrange.sdk.request.group;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.group.GroupMemberListResponse;

/**
 * @author lxy
 * @since 2024年09月11日 15:22:26
 */
public class QueryGroupMemberListRequest extends AbstractRequest<GroupMemberListResponse> {

    /**
     * 群号
     */
    private Long groupId;

    public QueryGroupMemberListRequest() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public String getServiceUrl() {
        return "get_group_member_list";
    }

    @Override
    public String getJsonParamString() {
        return JSONUtil.createObj()
                .putOpt("group_id", groupId)
                .toString();
    }

    @Override
    public Class<GroupMemberListResponse> getResponseClass() {
        return GroupMemberListResponse.class;
    }
}
