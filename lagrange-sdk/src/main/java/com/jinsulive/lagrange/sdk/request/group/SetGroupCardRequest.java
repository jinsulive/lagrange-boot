package com.jinsulive.lagrange.sdk.request.group;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.EmptyResponse;

/**
 * @author lxy
 * @since 2024年09月11日 14:52:48
 */
public class SetGroupCardRequest extends AbstractRequest<EmptyResponse> {
    /**
     * 群号
     */
    private Long groupId;
    /**
     * 要设置的 QQ 号
     */
    private Long userId;
    /**
     * 群名片内容，不填或空字符串表示删除群名片
     */
    private String card;

    public SetGroupCardRequest() {
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

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @Override
    public String getServiceUrl() {
        return "set_group_card";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("group_id", groupId)
                .putOpt("user_id", userId)
                .putOpt("card", card);
    }

    @Override
    public Class<EmptyResponse> getResponseClass() {
        return EmptyResponse.class;
    }
}
