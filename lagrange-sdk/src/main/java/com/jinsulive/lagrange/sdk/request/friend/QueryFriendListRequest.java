package com.jinsulive.lagrange.sdk.request.friend;

import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.friend.FriendInfoResponse;

/**
 * @author lxy
 * @since 2024年09月11日 15:09:56
 */
public class QueryFriendListRequest extends AbstractRequest<FriendInfoResponse> {
    @Override
    public String getServiceUrl() {
        return "get_friend_list";
    }

    @Override
    public String getJsonParamString() {
        return "{}";
    }

    @Override
    public Class<FriendInfoResponse> getResponseClass() {
        return FriendInfoResponse.class;
    }
}
