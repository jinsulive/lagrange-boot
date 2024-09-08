package com.jinsulive.lagrange.core.event.message;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.core.constant.PostType;
import com.jinsulive.lagrange.core.constant.message.SenderRoleType;
import com.jinsulive.lagrange.core.entity.message.Message;

import java.util.List;

/**
 * 群消息事件
 *
 * @author lxy
 * @since 2024年03月11日 17:50:57
 */
public class GroupMessageEvent {
    private Long time;
    private Long selfId;
    private PostType postType;
    private Integer messageId;
    private Long groupId;
    private Long userId;
    private String anonymous;
    private String nickname;
    private SenderRoleType role;
    private String title;
    /**
     * 纯文本消息
     */
    private String plainText;
    /**
     * 原始消息
     */
    private String rawMessage;
    /**
     * 原始消息链
     */
    private List<Message> sourceMessageChain;

    public GroupMessageEvent() {
    }

    private GroupMessageEvent(Builder builder) {
        time = builder.time;
        selfId = builder.selfId;
        postType = builder.postType;
        messageId = builder.messageId;
        groupId = builder.groupId;
        userId = builder.userId;
        anonymous = builder.anonymous;
        nickname = builder.nickname;
        role = builder.role;
        title = builder.title;
        plainText = builder.plainText;
        rawMessage = builder.rawMessage;
        sourceMessageChain = builder.sourceMessageChain;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getSelfId() {
        return selfId;
    }

    public void setSelfId(Long selfId) {
        this.selfId = selfId;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(String anonymous) {
        this.anonymous = anonymous;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public SenderRoleType getRole() {
        return role;
    }

    public void setRole(SenderRoleType role) {
        this.role = role;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getRawMessage() {
        return rawMessage;
    }

    public void setRawMessage(String rawMessage) {
        this.rawMessage = rawMessage;
    }

    public List<Message> getSourceMessageChain() {
        return sourceMessageChain;
    }

    public void setSourceMessageChain(List<Message> sourceMessageChain) {
        this.sourceMessageChain = sourceMessageChain;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public static final class Builder {
        private Long time;
        private Long selfId;
        private PostType postType;
        private Integer messageId;
        private Long groupId;
        private Long userId;
        private String anonymous;
        private String nickname;
        private SenderRoleType role;
        private String title;
        private String plainText;
        private String rawMessage;
        private List<Message> sourceMessageChain;

        private Builder() {
        }

        public Builder time(Long time) {
            this.time = time;
            return this;
        }

        public Builder selfId(Long selfId) {
            this.selfId = selfId;
            return this;
        }

        public Builder postType(PostType postType) {
            this.postType = postType;
            return this;
        }

        public Builder messageId(Integer messageId) {
            this.messageId = messageId;
            return this;
        }

        public Builder groupId(Long groupId) {
            this.groupId = groupId;
            return this;
        }

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder anonymous(String anonymous) {
            this.anonymous = anonymous;
            return this;
        }

        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder role(SenderRoleType role) {
            this.role = role;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder plainText(String plainText) {
            this.plainText = plainText;
            return this;
        }

        public Builder rawMessage(String rawMessage) {
            this.rawMessage = rawMessage;
            return this;
        }

        public Builder sourceMessageChain(List<Message> sourceMessageChain) {
            this.sourceMessageChain = sourceMessageChain;
            return this;
        }

        public GroupMessageEvent build() {
            return new GroupMessageEvent(this);
        }
    }

}
