package cn.jinsulive.lagrange.core.entity.message.data;

import cn.hutool.json.JSONUtil;

/**
 * markdown
 *
 * @author lxy
 * @since 2024年03月07日 00:08:01
 */
public class Markdown {
    private String content;

    public Markdown() {
    }

    private Markdown(Builder builder) {
        this.content = builder.content;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public static final class Builder {
        private String content;

        private Builder() {
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Markdown build() {
            return new Markdown(this);
        }
    }

}
