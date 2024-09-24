package cn.jinsulive.lagrange.core.entity.message.data;

import cn.hutool.json.JSONUtil;

/**
 * At某人
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E6%9F%90%E4%BA%BA">At某人</a>
 * @since 2024年03月06日 23:22:23
 */
public class At {
    /**
     * qq号
     */
    private String qq;
    /**
     * 昵称
     */
    private String name;

    public At() {
    }

    private At(Builder builder) {
        qq = builder.qq;
        name = builder.name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public static final class Builder {
        private String qq;

        private String name;

        private Builder() {
        }

        public Builder qq(String qq) {
            this.qq = qq;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public At build() {
            return new At(this);
        }
    }

}
