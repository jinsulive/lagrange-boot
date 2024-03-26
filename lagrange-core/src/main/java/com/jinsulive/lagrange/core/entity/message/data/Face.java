package com.jinsulive.lagrange.core.entity.message.data;

/**
 * QQ表情
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#qq-%E8%A1%A8%E6%83%85" />
 * @since 2024年03月06日 22:52:58
 */
public class Face {
    private String id;

    private Face(Builder builder) {
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

        public Face build() {
            return new Face(this);
        }
    }
}
