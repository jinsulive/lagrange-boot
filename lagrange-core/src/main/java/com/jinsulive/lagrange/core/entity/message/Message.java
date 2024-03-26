package com.jinsulive.lagrange.core.entity.message;

import com.jinsulive.lagrange.core.constant.message.MessageType;

/**
 * @author lxy
 * @since 2024年03月06日 14:30:31
 */
public class Message {

    private MessageType type;

    private Object data;

    public Message() {
    }

    private Message(Builder builder) {
        type = builder.type;
        data = builder.data;
    }

    public static Builder builder() {
        return new Builder();
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static final class Builder {
        private MessageType type;
        private Object data;

        private Builder() {
        }

        public Builder type(MessageType type) {
            this.type = type;
            return this;
        }

        public Builder data(Object data) {
            this.data = data;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}
