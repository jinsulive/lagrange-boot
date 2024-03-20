package com.jinsulive.lagrange.sdk.response.message.data;

import com.jinsulive.lagrange.core.constant.message.MessageEventType;
import com.jinsulive.lagrange.core.entity.message.Message;
import com.jinsulive.lagrange.core.entity.message.Sender;
import lombok.Data;

import java.util.List;

/**
 * @author lxy
 * @since 2024年03月20日 22:02:46
 */
@Data
public class MessageQueryData {
    private Long time;
    private MessageEventType messageType;
    private Long messageId;
    private Long realId;
    private Sender sender;
    private List<Message> message;
}
