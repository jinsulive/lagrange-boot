package com.jinsulive.lagrange.sdk.request.message;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.core.entity.message.Message;
import com.jinsulive.lagrange.sdk.request.LagrangeBotRequest;
import com.jinsulive.lagrange.sdk.response.message.MessageHandleResponse;

import java.util.List;

/**
 * @author lxy
 * @since 2024年03月15日 14:38:09
 */
public class SendGroupMessageRequest implements LagrangeBotRequest<MessageHandleResponse> {

    private Long groupId;

    private List<Message> message;

    public SendGroupMessageRequest() {
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    @Override
    public String getServiceUrl() {
        return "send_group_msg";
    }

    @Override
    public String getJsonParamString() {
        return JSONUtil.createObj()
                .putOpt("group_id", groupId)
                .putOpt("message", message)
                .toString();
    }

    @Override
    public Class<MessageHandleResponse> getResponseClass() {
        return MessageHandleResponse.class;
    }

}
