package com.jinsulive.lagrange.sdk.request.group;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.EmptyResponse;

/**
 * 退出群组
 *
 * @author lxy
 * @since 2024年09月11日 14:58:18
 */
public class SetGroupLeaveRequest extends AbstractRequest<EmptyResponse> {

    /**
     * 群号
     */
    private Long groupId;

    /**
     * 是否解散，如果登录号是群主，则仅在此项为 true 时能够解散
     */
    private Boolean isDismiss = false;

    public SetGroupLeaveRequest() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Boolean getDismiss() {
        return isDismiss;
    }

    public void setDismiss(Boolean dismiss) {
        isDismiss = dismiss;
    }

    @Override
    public String getServiceUrl() {
        return "set_group_leave";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("group_id", groupId)
                .putOpt("is_dismiss", isDismiss);
    }

    @Override
    public Class<EmptyResponse> getResponseClass() {
        return EmptyResponse.class;
    }
}
