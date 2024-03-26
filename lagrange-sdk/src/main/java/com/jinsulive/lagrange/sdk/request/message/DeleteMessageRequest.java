package com.jinsulive.lagrange.sdk.request.message;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.LagrangeBotRequest;
import com.jinsulive.lagrange.sdk.response.EmptyResponse;

/**
 * @author lxy
 * @since 2024年03月20日 22:00:07
 */
public class DeleteMessageRequest implements LagrangeBotRequest<EmptyResponse> {

    private Long messageId;

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    @Override
    public String getServiceUrl() {
        return "delete_msg";
    }

    @Override
    public String getJsonParamString() {
        return JSONUtil.createObj()
                .putOpt("message_id", messageId)
                .toString();
    }

    @Override
    public Class<EmptyResponse> getResponseClass() {
        return EmptyResponse.class;
    }

}
