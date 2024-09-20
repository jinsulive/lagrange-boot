package com.jinsulive.lagrange.core.event.message;

import com.jinsulive.lagrange.core.constant.core.MatchType;
import com.jinsulive.lagrange.core.constant.message.MessageEventType;
import com.jinsulive.lagrange.core.constant.message.MessageSubType;
import com.jinsulive.lagrange.core.entity.message.Message;
import com.jinsulive.lagrange.core.entity.message.Sender;
import com.jinsulive.lagrange.core.event.BaseEvent;

import java.util.List;

/**
 * @author lxy
 * @since 2024年03月06日 11:55:42
 */
public class MessageEvent extends BaseEvent {

    private MessageEventType messageType;
    private MessageSubType subType;
    private Long messageId;
    private Long groupId;
    private Long userId;
    private String anonymous;
    private List<Message> message;
    private String rawMessage;
    private Integer font;
    private Sender sender;
    private String plainText;
    private MatchType matchType;
    private String matchValue;

    public MessageEvent() {
    }

    public MessageEventType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageEventType messageType) {
        this.messageType = messageType;
    }

    public MessageSubType getSubType() {
        return subType;
    }

    public void setSubType(MessageSubType subType) {
        this.subType = subType;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
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

    public String getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(String anonymous) {
        this.anonymous = anonymous;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public String getRawMessage() {
        return rawMessage;
    }

    public void setRawMessage(String rawMessage) {
        this.rawMessage = rawMessage;
    }

    public Integer getFont() {
        return font;
    }

    public void setFont(Integer font) {
        this.font = font;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    public String getMatchValue() {
        return matchValue;
    }

    public void setMatchValue(String matchValue) {
        this.matchValue = matchValue;
    }

}
