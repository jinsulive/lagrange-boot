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
public class SendPrivateMessageRequest extends AbstractRequest<MessageHandleResponse> {

    private Long userId;

    private List<Message> message;

    public SendPrivateMessageRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    @Override
    public String getServiceUrl() {
        return "send_private_msg";
    }

    @Override
    public JSONObject getParamJson() {
        ConvertMessageUtil.convert(message);
        return JSONUtil.createObj()
                .putOpt("user_id", userId)
                .putOpt("message", message);
    }

    @Override
    public Class<MessageHandleResponse> getResponseClass() {
        return MessageHandleResponse.class;
    }

}
