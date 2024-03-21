package com.jinsulive.lagrange.sdk.request.info;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.LagrangeBotRequest;
import com.jinsulive.lagrange.sdk.response.info.StrangerInfoResponse;
import lombok.Data;

/**
 * @author lxy
 * @since 2024年03月21日 15:18:24
 */
@Data
public class QueryStrangerInfoRequest implements LagrangeBotRequest<StrangerInfoResponse> {
    private String userId;
    private Boolean noCache;

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