package com.jinsulive.lagrange.sdk.request.message;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.core.constant.message.MessageEventType;
import com.jinsulive.lagrange.core.entity.message.Message;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.message.MessageHandleResponse;
import com.jinsulive.lagrange.sdk.util.ConvertMessageUtil;

import java.util.List;

/**
 * @author lxy
 * @since 2024年03月15日 14:38:09
 */
public class SendMessageRequest extends AbstractRequest<MessageHandleResponse> {

    /**
     * 消息类型，如不传入，则根据传入的 *_id 参数判断
     */
    private MessageEventType messageType;

    private Long userId;

    private Long groupId;

    private List<Message> message;

    public SendMessageRequest() {
    }

    public MessageEventType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageEventType messageType) {
        this.messageType = messageType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    @Override
    public String getServiceUrl() {
        return "send_msg";
    }

    @Override
    public JSONObject getParamJson() {
        ConvertMessageUtil.convert(message);
        return JSONUtil.createObj()
                .putOpt("message_type", messageType)
                .putOpt("user_id", userId)
                .putOpt("group_id", groupId)
                .putOpt("message", message);
    }

    @Override
    public Class<MessageHandleResponse> getResponseClass() {
        return MessageHandleResponse.class;
    }

}
