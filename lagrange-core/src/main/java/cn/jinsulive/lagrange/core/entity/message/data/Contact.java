package cn.jinsulive.lagrange.core.entity.message.data;

import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.core.constant.message.data.ContactType;

/**
 * 推荐好友/群
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E9%93%BE%E6%8E%A5%E5%88%86%E4%BA%AB">推荐好友/群</a>
 * @since 2024年03月06日 23:30:00
 */
public class Contact {
    /**
     * 推荐类型
     */
    private ContactType type;
    /**
     * qq号/群号
     */
    private Long id;

    public Contact() {
    }

    private Contact(Builder builder) {
        type = builder.type;
        id = builder.id;
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

    public Long getQq() {
        return id;
    }

    public void setQq(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public static final class Builder {
        private ContactType type;
        private Long id;

        private Builder() {
        }

        public Builder type(ContactType type) {
            this.type = type;
            return this;
        }

        public Builder id(Long qq) {
            this.id = qq;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }

}
