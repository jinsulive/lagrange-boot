package com.jinsulive.lagrange.core.entity.message.data;

/**
 * json
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#json-%E6%B6%88%E6%81%AF" />
 * @since 2024年03月07日 00:16:28
 */
public class Json {
    private String data;

    private Json(Builder builder) {
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

        public Json build() {
            return new Json(this);
        }
    }
}
