package cn.jinsulive.lagrange.core.entity.message.data;

import cn.hutool.json.JSONUtil;

/**
 * 回复
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E5%9B%9E%E5%A4%8D" >回复</a>
 * @since 2024年03月07日 00:08:01
 */
public class Reply {
    /**
     * 回复的消息 ID
     */
    private Long id;

    public Reply() {
    }

    private Reply(Builder builder) {
        id = builder.id;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public static final class Builder {
        private Long id;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Reply build() {
            return new Reply(this);
        }
    }

}
