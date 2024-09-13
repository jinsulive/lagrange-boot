package com.jinsulive.lagrange.sdk.response.expand.data;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.core.entity.message.Message;

import java.util.List;

/**
 * 精华消息数据
 *
 * @author lxy
 * @since 2024年09月13日 14:01:09
 */
public class EssenceMessageData {

    /**
     * 发送人QQ号
     */
    private Long senderId;
    /**
     * 发送人昵称
     */
    private String senderNick;
    /**
     * 发送时间
     */
    private Long senderTime;
    /**
     * 操作人QQ号
     */
    private Long operatorId;
    /**
     * 操作人昵称
     */
    private String operatorNick;
    /**
     * 操作时间
     */
    private Long operatorTime;
    /**
     * 消息ID
     */
    private Long messageId;

    /**
     * 消息内容
     */
    private List<Message> content;

    public EssenceMessageData() {
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getSenderNick() {
        return senderNick;
    }

    public void setSenderNick(String senderNick) {
        this.senderNick = senderNick;
    }

    public Long getSenderTime() {
        return senderTime;
    }

    public void setSenderTime(Long senderTime) {
        this.senderTime = senderTime;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorNick() {
        return operatorNick;
    }

    public void setOperatorNick(String operatorNick) {
        this.operatorNick = operatorNick;
    }

    public Long getOperatorTime() {
        return operatorTime;
    }

    public void setOperatorTime(Long operatorTime) {
        this.operatorTime = operatorTime;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public List<Message> getContent() {
        return content;
    }

    public void setContent(List<Message> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

}
