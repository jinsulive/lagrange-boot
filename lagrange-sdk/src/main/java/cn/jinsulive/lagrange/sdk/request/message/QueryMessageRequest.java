package cn.jinsulive.lagrange.sdk.request.message;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.sdk.request.AbstractRequest;
import cn.jinsulive.lagrange.sdk.response.message.MessageQueryResponse;

/**
 * @author lxy
 * @since 2024年03月20日 21:54:25
 */
public class QueryMessageRequest extends AbstractRequest<MessageQueryResponse> {

    private Long messageId;

    public QueryMessageRequest() {
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    @Override
    public String getServiceUrl() {
        return "get_msg";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("message_id", messageId);
    }

    @Override
    public Class<MessageQueryResponse> getResponseClass() {
        return MessageQueryResponse.class;
    }

}
