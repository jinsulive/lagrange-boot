package com.jinsulive.lagrange.sdk.request.expand;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.expand.QueryEssenceMsgListResponse;

/**
 * 查询精华消息列表
 *
 * @author lxy
 * @since 2024年09月13日 13:58:19
 */
public class QueryEssenceMsgListRequest extends AbstractRequest<QueryEssenceMsgListResponse> {

    /**
     * 群号
     */
    private Long groupId;

    public QueryEssenceMsgListRequest() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public String getServiceUrl() {
        return "get_essence_msg_list";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("group_id", groupId);
    }

    @Override
    public Class<QueryEssenceMsgListResponse> getResponseClass() {
        return QueryEssenceMsgListResponse.class;
    }

}
