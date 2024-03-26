package com.jinsulive.lagrange.core.event.notice;

import com.jinsulive.lagrange.core.event.BaseEvent;

/**
 * @author lxy
 * @since 2024年03月06日 13:42:02
 */
public class NoticeEvent extends BaseEvent {
    private Integer groupId;
    private Integer userId;
    private Integer messageId;
    private Integer operatorId;
    private String noticeType;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }
}
