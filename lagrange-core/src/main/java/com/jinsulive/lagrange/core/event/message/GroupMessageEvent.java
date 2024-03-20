package com.jinsulive.lagrange.core.event.message;

import com.jinsulive.lagrange.core.constant.message.SenderRoleType;
import com.jinsulive.lagrange.core.entity.message.Message;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 群消息事件
 *
 * @author lxy
 * @since 2024年03月11日 17:50:57
 */
@Data
@Builder
public class GroupMessageEvent {
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

}
