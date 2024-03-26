package com.jinsulive.lagrange.spring.autoconfigure.entity;

import com.jinsulive.lagrange.core.annotation.message.MessageListenerInfo;

import java.util.List;

/**
 * 监听函数上下文
 *
 * @author lxy
 * @since 2024年03月11日 15:27:15
 */
public final class MethodListenerContext {

    private List<MessageListenerInfo> messageListenerInfos;

    public MethodListenerContext() {
    }

    private MethodListenerContext(Builder builder) {
        messageListenerInfos = builder.messageListenerInfos;
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<MessageListenerInfo> getMessageListenerInfos() {
        return messageListenerInfos;
    }

    public void setMessageListenerInfos(List<MessageListenerInfo> messageListenerInfos) {
        this.messageListenerInfos = messageListenerInfos;
    }

    public static final class Builder {
        private List<MessageListenerInfo> messageListenerInfos;

        private Builder() {
        }

        public Builder messageListenerInfos(List<MessageListenerInfo> messageListenerInfos) {
            this.messageListenerInfos = messageListenerInfos;
            return this;
        }

        public MethodListenerContext build() {
            return new MethodListenerContext(this);
        }
    }
}
