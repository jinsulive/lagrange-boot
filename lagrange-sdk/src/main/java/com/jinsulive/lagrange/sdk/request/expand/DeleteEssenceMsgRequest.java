package com.jinsulive.lagrange.sdk.request.expand;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.EmptyResponse;

/**
 * 删除精华消息
 *
 * @author lxy
 * @since 2024年09月13日 13:55:56
 */
public class DeleteEssenceMsgRequest extends AbstractRequest<EmptyResponse> {

    private Long messageId;

    public DeleteEssenceMsgRequest() {
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    @Override
    public String getServiceUrl() {
        return "delete_essence_msg";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("message_id", messageId);
    }

    @Override
    public Class<EmptyResponse> getResponseClass() {
        return EmptyResponse.class;
    }

}
