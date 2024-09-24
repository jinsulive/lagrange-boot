package cn.jinsulive.lagrange.sdk.request.message;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.core.entity.message.Message;
import cn.jinsulive.lagrange.sdk.request.AbstractRequest;
import cn.jinsulive.lagrange.sdk.response.message.MessageHandleResponse;
import cn.jinsulive.lagrange.sdk.util.ConvertMessageUtil;

import java.util.List;

/**
 * @author lxy
 * @since 2024年03月15日 14:38:09
 */
public class SendGroupMessageRequest extends AbstractRequest<MessageHandleResponse> {

    private Long groupId;

    private List<Message> message;

    public SendGroupMessageRequest() {
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
        return "send_group_msg";
    }

    @Override
    public JSONObject getParamJson() {
        ConvertMessageUtil.convert(message);
        return JSONUtil.createObj()
                .putOpt("group_id", groupId)
                .putOpt("message", message);
    }

    @Override
    public Class<MessageHandleResponse> getResponseClass() {
        return MessageHandleResponse.class;
    }

}
