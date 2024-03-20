package com.jinsulive.lagrange.core.entity.message;

import com.jinsulive.lagrange.core.constant.message.MessageType;
import lombok.Builder;
import lombok.Data;

/**
 * @author lxy
 * @since 2024年03月06日 14:30:31
 */
@Data
@Builder
public class Message {

    private MessageType type;

    private Object data;

}
