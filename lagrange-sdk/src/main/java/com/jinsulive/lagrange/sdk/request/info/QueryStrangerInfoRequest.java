package com.jinsulive.lagrange.sdk.request.info;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.info.StrangerInfoResponse;

/**
 * 获取陌生人信息
 *
 * @author lxy
 * @since 2024年03月21日 15:18:24
 */
public class QueryStrangerInfoRequest extends AbstractRequest<StrangerInfoResponse> {
    private Long userId;
    private Boolean noCache = false;

    public QueryStrangerInfoRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getNoCache() {
        return noCache;
    }

    public void setNoCache(Boolean noCache) {
        this.noCache = noCache;
    }

    @Override
    public String getServiceUrl() {
        return "get_stranger_info";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("user_id", userId)
                .putOpt("no_cache", noCache);
    }

    @Override
    public Class<StrangerInfoResponse> getResponseClass() {
        return StrangerInfoResponse.class;
    }
}