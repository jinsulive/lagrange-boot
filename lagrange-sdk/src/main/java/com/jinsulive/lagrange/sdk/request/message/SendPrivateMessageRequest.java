package com.jinsulive.lagrange.sdk.request.message;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.core.entity.message.Message;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.message.MessageHandleResponse;

import java.util.List;

/**
 * @author lxy
 * @since 2024年03月15日 14:38:09
 */
public class SendPrivateMessageRequest extends AbstractRequest<MessageHandleResponse> {

    private Long userId;

    private List<Message> message;

    public SendPrivateMessageRequest() {
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

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
