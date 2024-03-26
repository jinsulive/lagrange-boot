package com.jinsulive.lagrange.core.entity.message.data;

/**
 * At某人
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E6%9F%90%E4%BA%BA" />
 * @since 2024年03月06日 23:22:23
 */
public class At {

    private String qq;

    public At() {
    }

    private At(Builder builder) {
        qq = builder.qq;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public static final class Builder {
        private String qq;

        private Builder() {
        }

        public Builder qq(String qq) {
            this.qq = qq;
            return this;
        }

        public At build() {
            return new At(this);
        }
    }
}
