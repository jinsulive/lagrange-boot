package com.jinsulive.lagrange.core.event.message;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.core.entity.message.Message;

import java.util.List;

/**
 * 好友消息事件
 *
 * @author lxy
 * @since 2024年03月11日 17:51:21
 */
public class FriendMessageEvent {
    private Integer messageId;
    private Long userId;
    private String nickname;
    /**
     * 纯文本消息
     */
    private String plainText;
    /**
     * 原始消息
     */
    private String rawMessage;
    /**
     * 原始消息链
     */
    private List<Message> sourceMessageChain;

    public FriendMessageEvent() {
    }

    private FriendMessageEvent(Builder builder) {
        messageId = builder.messageId;
        userId = builder.userId;
        nickname = builder.nickname;
        plainText = builder.plainText;
        rawMessage = builder.rawMessage;
        sourceMessageChain = builder.sourceMessageChain;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getRawMessage() {
        return rawMessage;
    }

    public void setRawMessage(String rawMessage) {
        this.rawMessage = rawMessage;
    }

    public List<Message> getSourceMessageChain() {
        return sourceMessageChain;
    }

    public void setSourceMessageChain(List<Message> sourceMessageChain) {
        this.sourceMessageChain = sourceMessageChain;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public static final class Builder {
        private Integer messageId;
        private Long userId;
        private String nickname;
        private String plainText;
        private String rawMessage;
        private List<Message> sourceMessageChain;

        private Builder() {
        }

        public Builder messageId(Integer messageId) {
            this.messageId = messageId;
            return this;
        }

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder plainText(String plainText) {
            this.plainText = plainText;
            return this;
        }

        public Builder rawMessage(String rawMessage) {
            this.rawMessage = rawMessage;
            return this;
        }

        public Builder sourceMessageChain(List<Message> sourceMessageChain) {
            this.sourceMessageChain = sourceMessageChain;
            return this;
        }

        public FriendMessageEvent build() {
            return new FriendMessageEvent(this);
        }
    }

}
