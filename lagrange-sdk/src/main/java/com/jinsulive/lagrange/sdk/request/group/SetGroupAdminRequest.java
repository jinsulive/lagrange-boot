package com.jinsulive.lagrange.sdk.request.group;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.EmptyResponse;

/**
 * 群组设置管理员
 *
 * @author lxy
 * @since 2024年09月11日 14:48:40
 */
public class SetGroupAdminRequest extends AbstractRequest<EmptyResponse> {

    /**
     * 群号
     */
    private Long groupId;
    /**
     * 要设置管理员的QQ号
     */
    private Long userId;
    /**
     * 是否设置为管理员 默认 true
     */
    private Boolean enable = true;

    public SetGroupAdminRequest() {
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

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @Override
    public String getServiceUrl() {
        return "set_group_admin";
    }

    @Override
    public String getJsonParamString() {
        return JSONUtil.createObj()
                .putOpt("group_id", groupId)
                .putOpt("user_id", userId)
                .putOpt("enable", enable)
                .toString();
    }

    @Override
    public Class<EmptyResponse> getResponseClass() {
        return EmptyResponse.class;
    }

}
