package com.jinsulive.lagrange.core.entity.message.data;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.core.entity.message.Message;

import java.util.List;

/**
 * 合并转发/合并转发节点
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E5%90%88%E5%B9%B6%E8%BD%AC%E5%8F%91%E8%8A%82%E7%82%B9-" />
 * @since 2024年03月07日 00:13:29
 */
public class Node {

    private String id;
    private Long userId;
    private String nickname;
    private List<Message> content;

    public Node() {
    }

    private Node(Builder builder) {
        id = builder.id;
        userId = builder.userId;
        nickname = builder.nickname;
        content = builder.content;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
        private String id;
        private Long userId;
        private String nickname;
        private List<Message> content;

        private Builder() {
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder nickname(String nickname) {
            this.nickname = nickname;
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
