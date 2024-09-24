package cn.jinsulive.lagrange.core.entity.message.data;

import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.core.entity.message.Message;

import java.util.List;

/**
 *
 * @author lxy
 * @since 2024年03月07日 00:13:29
 */
public class Node {

    private Long userId;
    private String nickname;
    private String uin;
    private String name;
    private List<Message> content;

    public Node() {
    }

    private Node(Builder builder) {
        userId = builder.userId;
        nickname = builder.nickname;
        uin = builder.uin;
        name = builder.name;
        content = builder.content;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Deprecated
    public Long getUserId() {
        return userId;
    }

    @Deprecated
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Deprecated
    public String getNickname() {
        return nickname;
    }

    @Deprecated
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUin() {
        return uin;
    }

    public void setUin(String uin) {
        this.uin = uin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getContent() {
        return content;
    }

    public void setContent(List<Message> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public static final class Builder {
        private Long userId;
        private String nickname;
        private String uin;
        private String name;
        private List<Message> content;

        private Builder() {
        }

        @Deprecated
        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        @Deprecated
        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder uin(String uin) {
            this.uin = uin;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder content(List<Message> content) {
            this.content = content;
            return this;
        }

        public Node build() {
            return new Node(this);
        }
    }

}
