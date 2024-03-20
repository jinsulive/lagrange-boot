package com.jinsulive.lagrange.sdk.request.message;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.LagrangeBotRequest;
import com.jinsulive.lagrange.sdk.response.message.MessageQueryResponse;
import lombok.Data;

/**
 * @author lxy
 * @since 2024年03月20日 21:54:25
 */
@Data
public class QueryMessageRequest implements LagrangeBotRequest<MessageQueryResponse> {

    private Long messageId;

    @Override
    public String getServiceUrl() {
        return "get_msg";
    }

    @Override
    public String getJsonParamString() {
        return JSONUtil.createObj()
                .putOpt("message_id", messageId)
                .toString();
    }

    @Override
    public Class<MessageQueryResponse> getResponseClass() {
        return MessageQueryResponse.class;
    }

}
