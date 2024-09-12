package com.jinsulive.lagrange.sdk.request.group;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.EmptyResponse;

/**
 * 群组匿名设置
 *
 * @author lxy
 * @since 2024年09月11日 14:50:41
 */
public class SetGroupAnonymousRequest extends AbstractRequest<EmptyResponse> {

    /**
     * 群号
     */
    private Long groupId;
    /**
     * 是否允许匿名聊天 默认 true
     */
    private Boolean enable = true;

    public SetGroupAnonymousRequest() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @Override
    public String getServiceUrl() {
        return "set_group_anonymous";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("group_id", groupId)
                .putOpt("enable", enable);
    }

    @Override
    public Class<EmptyResponse> getResponseClass() {
        return EmptyResponse.class;
    }

}
