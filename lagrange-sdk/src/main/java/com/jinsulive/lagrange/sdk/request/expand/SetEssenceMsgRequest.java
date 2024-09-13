package com.jinsulive.lagrange.sdk.request.expand;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.EmptyResponse;

/**
 * 设置精华消息
 *
 * @author lxy
 * @since 2024年09月13日 15:46:29
 */
public class SetEssenceMsgRequest extends AbstractRequest<EmptyResponse> {

    private Long messageId;

    public SetEssenceMsgRequest() {
    }

    public SetEssenceMsgRequest(Long messageId) {
        this.messageId = messageId;
    }

    public Long getMessageId() {
        return messageId;
    }

    @Override
    public String getServiceUrl() {
        return "set_essence_msg";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .set("message_id", messageId);
    }

    @Override
    public Class<EmptyResponse> getResponseClass() {
        return EmptyResponse.class;
    }
}
