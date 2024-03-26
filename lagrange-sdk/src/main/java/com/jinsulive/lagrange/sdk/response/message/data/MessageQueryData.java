package com.jinsulive.lagrange.sdk.response.message.data;

import com.jinsulive.lagrange.core.constant.message.MessageEventType;
import com.jinsulive.lagrange.core.entity.message.Message;
import com.jinsulive.lagrange.core.entity.message.Sender;

import java.util.List;

/**
 * @author lxy
 * @since 2024年03月20日 22:02:46
 */
public class MessageQueryData {
    private Long time;
    private MessageEventType messageType;
    private Long messageId;
    private Long realId;
    private Sender sender;
    private List<Message> message;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public MessageEventType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageEventType messageType) {
        this.messageType = messageType;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getRealId() {
        return realId;
    }

    public void setRealId(Long realId) {
        this.realId = realId;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }
}
