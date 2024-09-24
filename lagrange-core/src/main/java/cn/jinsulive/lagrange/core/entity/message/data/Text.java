package cn.jinsulive.lagrange.core.entity.message.data;

import cn.hutool.json.JSONUtil;

/**
 * 纯文本
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E7%BA%AF%E6%96%87%E6%9C%AC" />
 * @since 2024年03月06日 22:51:58
 */
public class Text {
    private String text;

    public Text() {
    }

    private Text(Builder builder) {
        text = builder.text;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public static final class Builder {
        private String text;

        private Builder() {
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Text build() {
            return new Text(this);
        }
    }

}
