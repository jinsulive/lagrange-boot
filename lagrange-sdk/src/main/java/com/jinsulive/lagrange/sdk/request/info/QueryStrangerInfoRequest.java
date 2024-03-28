package com.jinsulive.lagrange.sdk.request.info;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.info.StrangerInfoResponse;

/**
 * @author lxy
 * @since 2024年03月21日 15:18:24
 */
public class QueryStrangerInfoRequest extends AbstractRequest<StrangerInfoResponse> {
    private String userId;
    private Boolean noCache;

    public QueryStrangerInfoRequest() {
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setNoCache(Boolean noCache) {
        this.noCache = noCache;
    }

    @Override
    public String getServiceUrl() {
        return "get_stranger_info";
    }

    @Override
    public String getJsonParamString() {
        return JSONUtil.createObj()
                .putOpt("user_id", userId)
                .putOpt("no_cache", noCache)
                .toString();
    }

    @Override
    public Class<StrangerInfoResponse> getResponseClass() {
        return StrangerInfoResponse.class;
    }
}