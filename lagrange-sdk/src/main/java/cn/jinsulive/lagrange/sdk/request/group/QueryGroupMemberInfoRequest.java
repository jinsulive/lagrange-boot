package cn.jinsulive.lagrange.sdk.request.group;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.sdk.request.AbstractRequest;
import cn.jinsulive.lagrange.sdk.response.group.GroupMemberInfoResponse;

/**
 * 获取群成员信息
 *
 * @author lxy
 * @since 2024年09月11日 14:07:42
 */
public class QueryGroupMemberInfoRequest extends AbstractRequest<GroupMemberInfoResponse> {

    /**
     * 群号
     */
    private Long groupId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 是否不使用缓存（使用缓存可能更新不及时，但响应更快）
     */
    private Boolean noCache = false;

    public QueryGroupMemberInfoRequest() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("group_id", groupId)
                .putOpt("user_id", userId)
                .putOpt("no_cache", noCache);
    }

    @Override
    public Class<GroupMemberInfoResponse> getResponseClass() {
        return GroupMemberInfoResponse.class;
    }
}
