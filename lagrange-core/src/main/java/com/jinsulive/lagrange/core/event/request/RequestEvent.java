package com.jinsulive.lagrange.core.event.request;

import com.jinsulive.lagrange.core.constant.request.RequestSubType;
import com.jinsulive.lagrange.core.constant.request.RequestType;
import com.jinsulive.lagrange.core.event.BaseEvent;

/**
 * @author lxy
 * @since 2024年03月06日 13:42:02
 */
public class RequestEvent extends BaseEvent {

    /**
     * 请求类型
     */
    private RequestType requestType;

    /**
     * 请求子类型
     * 仅加群请求／邀请
     */
    private RequestSubType subType;

    /**
     * 群号
     * 仅加群请求／邀请
     */
    private Long groupId;
    /**
     * 发送请求的 QQ 号
     */
    private Long userId;
    /**
     * 验证信息
     */
    private String comment;
    /**
     * 请求 flag，在调用处理请求的 API 时需要传入
     */
    private String flag;

    public RequestEvent() {
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public RequestSubType getSubType() {
        return subType;
    }

    public void setSubType(RequestSubType subType) {
        this.subType = subType;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
