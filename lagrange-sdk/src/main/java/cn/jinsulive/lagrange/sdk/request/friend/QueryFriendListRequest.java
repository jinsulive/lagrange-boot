package cn.jinsulive.lagrange.sdk.request.friend;

import cn.hutool.http.Method;
import cn.jinsulive.lagrange.sdk.request.AbstractRequest;
import cn.jinsulive.lagrange.sdk.response.friend.FriendInfoResponse;

/**
 * 获取好友列表
 *
 * @author lxy
 * @since 2024年09月11日 15:09:56
 */
public class QueryFriendListRequest extends AbstractRequest<FriendInfoResponse> {
    @Override
    public String getServiceUrl() {
        return "get_friend_list";
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public Class<FriendInfoResponse> getResponseClass() {
        return FriendInfoResponse.class;
    }
}
