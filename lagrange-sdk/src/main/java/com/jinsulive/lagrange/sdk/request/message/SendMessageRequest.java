package com.jinsulive.lagrange.sdk.request.message;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.core.constant.message.MessageEventType;
import com.jinsulive.lagrange.core.entity.message.Message;
import com.jinsulive.lagrange.sdk.request.LagrangeBotRequest;
import com.jinsulive.lagrange.sdk.response.message.MessageHandleResponse;
import lombok.Data;

import java.util.List;

/**
 * @author lxy
 * @since 2024年03月15日 14:38:09
 */
@Data
public class SendMessageRequest implements LagrangeBotRequest<MessageHandleResponse> {

    /**
     * 消息类型，如不传入，则根据传入的 *_id 参数判断
     */
    private MessageEventType messageType;

    private Long userId;

    private Long groupId;

    private List<Message> message;

    @Override
    public String getServiceUrl() {
        return "send_msg";
    }

    @Override
    public String getJsonParamString() {
        return JSONUtil.createObj()
                .putOpt("message_type", messageType)
                .putOpt("user_id", userId)
                .putOpt("group_id", groupId)
                .putOpt("message", message)
                .toString();
    }

    @Override
    public Class<MessageHandleResponse> getResponseClass() {
        return MessageHandleResponse.class;
    }

}
