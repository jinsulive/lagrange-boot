package com.jinsulive.lagrange.core.event.message;

import com.jinsulive.lagrange.core.entity.message.Message;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 好友消息事件
 *
 * @author lxy
 * @since 2024年03月11日 17:51:21
 */
@Data
@Builder
public class FriendMessageEvent {
    private Integer messageId;
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
}
