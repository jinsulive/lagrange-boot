package com.jinsulive.lagrange.sdk.request.expand;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.expand.QueryMsgHistoryResponse;

/**
 * 获取群历史消息记录
 *
 * @author lxy
 * @since 2024年09月12日 17:22:21
 */
public class QueryGroupMsgHistoryRequest extends AbstractRequest<QueryMsgHistoryResponse> {

    /**
     * 群号
     */
    private Long groupId;
    /**
     * 要获取的消息的最后一条的ID
     */
    private Long messageId;
    /**
     * 获取的消息数量
     */
    private Integer count;

    public QueryGroupMsgHistoryRequest() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String getServiceUrl() {
        return "get_group_msg_history";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("group_id", groupId)
                .putOpt("message_id", messageId)
                .putOpt("count", count);
    }

    @Override
    public Class<QueryMsgHistoryResponse> getResponseClass() {
        return QueryMsgHistoryResponse.class;
    }
}
