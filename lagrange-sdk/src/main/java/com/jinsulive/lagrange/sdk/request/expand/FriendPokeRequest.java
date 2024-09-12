package com.jinsulive.lagrange.sdk.request.expand;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.EmptyResponse;

/**
 * 好友戳一戳
 *
 * @author lxy
 * @since 2024年09月12日 17:45:47
 */
public class FriendPokeRequest extends AbstractRequest<EmptyResponse> {

    /**
     * 好友qq号
     */
    private Long userId;

    public FriendPokeRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String getServiceUrl() {
        return "friend_poke";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("user_id", userId);
    }

    @Override
    public Class<EmptyResponse> getResponseClass() {
        return EmptyResponse.class;
    }
}
