package com.jinsulive.lagrange.sdk.request.group;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.EmptyResponse;

/**
 * 群组匿名用户禁言
 * anonymous 和 anonymous_flag 两者任选其一传入即可，若都传入，则使用 anonymous
 *
 * @author lxy
 * @since 2024年09月11日 14:41:48
 */
public class SetGroupAnonymousBanRequest extends AbstractRequest<EmptyResponse> {

    /**
     * 群号
     */
    private Long groupId;
    /**
     * 可选，要禁言的匿名用户对象（群消息上报的 anonymous 字段）
     */
    private Object anonymous;
    /**
     * 可选，要禁言的匿名用户的 flag（需从群消息上报的数据中获得）
     */
    private String anonymousFlag;
    /**
     * 禁言时长，单位秒，无法取消匿名用户禁言 默认 30 * 60
     */
    private Integer duration = 30 * 60;

    public SetGroupAnonymousBanRequest() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Object getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(Object anonymous) {
        this.anonymous = anonymous;
    }

    public String getAnonymousFlag() {
        return anonymousFlag;
    }

    public void setAnonymousFlag(String anonymousFlag) {
        this.anonymousFlag = anonymousFlag;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String getServiceUrl() {
        return "set_group_anonymous_ban";
    }

    @Override
    public String getJsonParamString() {
        return JSONUtil.createObj()
                .putOpt("group_id", groupId)
                .putOpt("anonymous", anonymous)
                .putOpt("anonymous_flag", anonymousFlag)
                .putOpt("duration", duration)
                .toString();
    }

    @Override
    public Class<EmptyResponse> getResponseClass() {
        return EmptyResponse.class;
    }
}
