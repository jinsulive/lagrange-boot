package cn.jinsulive.lagrange.sdk.request.group;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.sdk.request.AbstractRequest;
import cn.jinsulive.lagrange.sdk.response.group.GroupMemberListResponse;

/**
 * 获取群成员列表
 *
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
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("group_id", groupId);
    }

    @Override
    public Class<GroupMemberListResponse> getResponseClass() {
        return GroupMemberListResponse.class;
    }
}
