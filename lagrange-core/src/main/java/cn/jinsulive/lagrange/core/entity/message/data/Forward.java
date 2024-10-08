package cn.jinsulive.lagrange.core.entity.message.data;

import cn.hutool.json.JSONUtil;

/**
 * 合并转发
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E5%90%88%E5%B9%B6%E8%BD%AC%E5%8F%91-">合并转发</a>
 * @since 2024年03月07日 00:10:53
 */
public class Forward {
    /**
     * 转发消息ID
     */
    private String id;

    public Forward() {
    }

    private Forward(Builder builder) {
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

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public static final class Builder {
        private String id;

        private Builder() {
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Forward build() {
            return new Forward(this);
        }
    }

}
