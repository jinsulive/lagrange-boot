package com.jinsulive.lagrange.sdk.request.group;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.EmptyResponse;

/**
 * 群组设置专属头衔
 *
 * @author lxy
 * @since 2024年09月11日 15:00:43
 */
public class SetGroupSpecialTitleRequest extends AbstractRequest<EmptyResponse> {

    /**
     * 群号
     */
    private Long groupId;
    /**
     * 要设置的QQ号
     */
    private Long userId;
    /**
     * 专属头衔，不填或空字符串表示删除专属头衔
     */
    private String specialTitle;
    /**
     * 专属头衔有效期，单位秒，-1 表示永久
     * 不过此项似乎没有效果，可能是只有某些特殊的时间长度有效，有待测试
     */
    private Integer duration = -1;

    public SetGroupSpecialTitleRequest() {
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

    public String getSpecialTitle() {
        return specialTitle;
    }

    public void setSpecialTitle(String specialTitle) {
        this.specialTitle = specialTitle;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String getServiceUrl() {
        return "set_group_special_title";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("group_id", groupId)
                .putOpt("user_id", userId)
                .putOpt("special_title", specialTitle)
                .putOpt("duration", duration);
    }

    @Override
    public Class<EmptyResponse> getResponseClass() {
        return EmptyResponse.class;
    }
}
