package com.jinsulive.lagrange.sdk.request.group;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.EmptyResponse;

/**
 * 群组单人禁言
 *
 * @author lxy
 * @since 2024年09月11日 14:39:12
 */
public class SetGroupBanRequest extends AbstractRequest<EmptyResponse> {

    /**
     * 群号
     */
    private Long groupId;
    /**
     * 要禁言的QQ号
     */
    private Long userId;
    /**
     * 禁言时长，单位秒，0 表示取消禁言 默认 30 * 60
     */
    private Integer duration = 30 * 60;


    public SetGroupBanRequest() {
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String getServiceUrl() {
        return "set_group_ban";
    }

    @Override
    public String getJsonParamString() {
        return JSONUtil.createObj()
                .putOpt("group_id", groupId)
                .putOpt("user_id", userId)
                .putOpt("duration", duration)
                .toString();
    }

    @Override
    public Class<EmptyResponse> getResponseClass() {
        return EmptyResponse.class;
    }
}
