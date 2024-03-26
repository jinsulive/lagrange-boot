package com.jinsulive.lagrange.core.entity.message.data;

/**
 * xml
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#xml-%E6%B6%88%E6%81%AF" />
 * @since 2024年03月07日 00:16:28
 */
public class Xml {
    private String data;

    private Xml(Builder builder) {
        data = builder.data;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static final class Builder {
        private String data;

        private Builder() {
        }

        public Builder data(String data) {
            this.data = data;
            return this;
        }

        public Xml build() {
            return new Xml(this);
        }
    }
}
