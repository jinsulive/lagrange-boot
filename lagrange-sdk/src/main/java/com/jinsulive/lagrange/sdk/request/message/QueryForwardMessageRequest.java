package com.jinsulive.lagrange.sdk.request.message;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.message.MessageQueryResponse;

/**
 * @author lxy
 * @since 2024年09月11日 13:48:54
 */
public class QueryForwardMessageRequest extends AbstractRequest<MessageQueryResponse> {

    private String id;

    public QueryForwardMessageRequest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getServiceUrl() {
        return "get_forward_msg";
    }

    @Override
    public String getJsonParamString() {
        return JSONUtil.createObj()
                .putOpt("id", id)
                .toString();
    }

    @Override
    public Class<MessageQueryResponse> getResponseClass() {
        return MessageQueryResponse.class;
    }
}
