package cn.jinsulive.lagrange.core.event.message;

import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.core.entity.message.Message;
import cn.jinsulive.lagrange.core.constant.PostType;
import cn.jinsulive.lagrange.core.constant.core.MatchType;

import java.util.List;

/**
 * 好友消息事件
 *
 * @author lxy
 * @since 2024年03月11日 17:51:21
 */
public class FriendMessageEvent {

    private Long time;
    private Long selfId;
    private PostType postType;
    private Long messageId;
    private Long userId;
    private String nickname;
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
    /**
     * 匹配类型
     */
    private MatchType matchType;
    /**
     * 匹配规则
     */
    private String matchValue;

    public FriendMessageEvent() {
    }

    private FriendMessageEvent(Builder builder) {
        time = builder.time;
        selfId = builder.selfId;
        postType = builder.postType;
        messageId = builder.messageId;
        userId = builder.userId;
        nickname = builder.nickname;
        plainText = builder.plainText;
        rawMessage = builder.rawMessage;
        sourceMessageChain = builder.sourceMessageChain;
        matchType = builder.matchType;
        matchValue = builder.matchValue;
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

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
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

    public MatchType getMatchType() {
        return matchType;
    }

    public void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    public String getMatchValue() {
        return matchValue;
    }

    public void setMatchValue(String matchValue) {
        this.matchValue = matchValue;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public static final class Builder {
        private Long time;
        private Long selfId;
        private PostType postType;
        private Long messageId;
        private Long userId;
        private String nickname;
        private String plainText;
        private String rawMessage;
        private List<Message> sourceMessageChain;
        private MatchType matchType;
        private String matchValue;

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

        public Builder messageId(Long messageId) {
            this.messageId = messageId;
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

        public Builder matchType(MatchType matchType) {
            this.matchType = matchType;
            return this;
        }

        public Builder matchValue(String matchValue) {
            this.matchValue = matchValue;
            return this;
        }

        public FriendMessageEvent build() {
            return new FriendMessageEvent(this);
        }
    }

}
