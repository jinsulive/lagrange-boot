package com.jinsulive.lagrange.sdk.request.group;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.group.GroupMemberInfoResponse;

/**
 * @author lxy
 * @since 2024年09月11日 14:07:42
 */
public class QueryGroupMemberInfoRequest extends AbstractRequest<GroupMemberInfoResponse> {

    /**
     * 群号
     */
    private String groupId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 是否不使用缓存（使用缓存可能更新不及时，但响应更快）
     */
    private Boolean noCache = false;

    public QueryGroupMemberInfoRequest() {
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getNoCache() {
        return noCache;
    }

    public void setNoCache(Boolean noCache) {
        this.noCache = noCache;
    }

    @Override
    public String getServiceUrl() {
        return "get_group_member_info";
    }

    @Override
    public String getJsonParamString() {
        return JSONUtil.createObj()
                .putOpt("group_id", groupId)
                .putOpt("user_id", userId)
                .putOpt("no_cache", noCache)
                .toString();
    }

    @Override
    public Class<GroupMemberInfoResponse> getResponseClass() {
        return GroupMemberInfoResponse.class;
    }
}
