package com.jinsulive.lagrange.sdk.request.expand;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.core.entity.message.Message;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.expand.SendForwardMessageResponse;

import java.util.List;

/**
 * 构造转发消息(群聊)
 *
 * @author lxy
 * @since 2024年09月17日 01:21:07
 */
public class SendGroupForwardMsgRequest extends AbstractRequest<SendForwardMessageResponse> {

    private List<Message> messages;

    public SendGroupForwardMsgRequest() {
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String getServiceUrl() {
        return "send_group_forward_msg";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("messages", messages);
    }

    @Override
    public Class<SendForwardMessageResponse> getResponseClass() {
        return SendForwardMessageResponse.class;
    }

}