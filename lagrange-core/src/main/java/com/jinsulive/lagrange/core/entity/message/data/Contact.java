package com.jinsulive.lagrange.core.entity.message.data;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.core.constant.message.data.ContactType;

/**
 * 推荐好友/群
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E9%93%BE%E6%8E%A5%E5%88%86%E4%BA%AB" />
 * @since 2024年03月06日 23:30:00
 */
public class Contact {
    private ContactType type;
    private String qq;

    public Contact() {
    }

    private Contact(Builder builder) {
        type = builder.type;
        qq = builder.qq;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public static final class Builder {
        private ContactType type;
        private String qq;

        private Builder() {
        }

        public Builder type(ContactType type) {
            this.type = type;
            return this;
        }

        public Builder qq(String qq) {
            this.qq = qq;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }

}
