package com.jinsulive.lagrange.core.entity.message.data;

/**
 * 回复
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E5%9B%9E%E5%A4%8D" />
 * @since 2024年03月07日 00:08:01
 */
public class Reply {
    private String id;

    private Reply(Builder builder) {
        id = builder.id;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static final class Builder {
        private String id;

        private Builder() {
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Reply build() {
            return new Reply(this);
        }
    }
}
