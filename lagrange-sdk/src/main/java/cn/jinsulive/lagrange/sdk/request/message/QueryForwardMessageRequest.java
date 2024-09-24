package cn.jinsulive.lagrange.sdk.request.message;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.sdk.request.AbstractRequest;
import cn.jinsulive.lagrange.sdk.response.message.QueryForwardMessageResponse;

/**
 * 获取合并转发消息
 *
 * @author lxy
 * @since 2024年09月11日 13:48:54
 */
public class QueryForwardMessageRequest extends AbstractRequest<QueryForwardMessageResponse> {

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
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("id", id);
    }

    @Override
    public Class<QueryForwardMessageResponse> getResponseClass() {
        return QueryForwardMessageResponse.class;
    }
}
