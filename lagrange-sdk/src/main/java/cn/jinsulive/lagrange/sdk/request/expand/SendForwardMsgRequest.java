package cn.jinsulive.lagrange.sdk.request.expand;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.core.entity.message.Message;
import cn.jinsulive.lagrange.sdk.request.AbstractRequest;
import cn.jinsulive.lagrange.sdk.response.expand.SendForwardMsgResponse;

import java.util.List;

/**
 * 构造合并转发消息
 *
 * @author lxy
 * @since 2024年09月17日 01:21:07
 */
public class SendForwardMsgRequest extends AbstractRequest<SendForwardMsgResponse> {

    private List<Message> messages;

    public SendForwardMsgRequest() {
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String getServiceUrl() {
        return "send_forward_msg";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("messages", messages);
    }

    @Override
    public Class<SendForwardMsgResponse> getResponseClass() {
        return SendForwardMsgResponse.class;
    }

}