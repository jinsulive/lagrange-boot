package com.jinsulive.lagrange.core.event.message;

import com.jinsulive.lagrange.core.constant.message.MessageEventType;
import com.jinsulive.lagrange.core.constant.message.MessageSubType;
import com.jinsulive.lagrange.core.entity.message.Message;
import com.jinsulive.lagrange.core.entity.message.Sender;
import com.jinsulive.lagrange.core.event.BaseEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author lxy
 * @since 2024年03月06日 11:55:42
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MessageEvent extends BaseEvent {

    private MessageEventType messageType;
    private MessageSubType subType;
    private Integer messageId;
    private Long groupId;
    private Long userId;
    private String anonymous;
    private List<Message> message;
    private String rawMessage;
    private Integer font;
    private Sender sender;
    private String plainText;

}
