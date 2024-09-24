package cn.jinsulive.lagrange.sdk.request.group;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.sdk.request.AbstractRequest;
import cn.jinsulive.lagrange.sdk.response.EmptyResponse;

/**
 * 群组踢人
 *
 * @author lxy
 * @since 2024年09月11日 14:32:13
 */
public class SetGroupKickRequest extends AbstractRequest<EmptyResponse> {

    /**
     * 群号
     */
    private Long groupId;
    /**
     * 要踢的QQ号
     */
    private Long userId;
    /**
     * 拒绝此人的加群请求 默认不拒绝
     */
    private Boolean rejectAddRequest = false;

    public SetGroupKickRequest() {
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

    public Boolean getRejectAddRequest() {
        return rejectAddRequest;
    }

    public void setRejectAddRequest(Boolean rejectAddRequest) {
        this.rejectAddRequest = rejectAddRequest;
    }

    @Override
    public String getServiceUrl() {
        return "set_group_kick";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("group_id", groupId)
                .putOpt("user_id", userId)
                .putOpt("reject_add_request", rejectAddRequest);
    }

    @Override
    public Class<EmptyResponse> getResponseClass() {
        return EmptyResponse.class;
    }
}
