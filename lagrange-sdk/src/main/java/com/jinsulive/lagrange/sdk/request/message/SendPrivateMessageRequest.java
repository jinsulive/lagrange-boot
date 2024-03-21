package com.jinsulive.lagrange.sdk.request.message;

import cn.hutool.json.JSONUtil;
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
public class SendPrivateMessageRequest implements LagrangeBotRequest<MessageHandleResponse> {

    private Long userId;

    private List<Message> message;

    @Override
    public String getServiceUrl() {
        return "send_private_msg";
    }

    @Override
    public String getJsonParamString() {
        return JSONUtil.createObj()
                .putOpt("user_id", userId)
                .putOpt("message", message)
                .toString();
    }

    @Override
    public Class<MessageHandleResponse> getResponseClass() {
        return MessageHandleResponse.class;
    }

}