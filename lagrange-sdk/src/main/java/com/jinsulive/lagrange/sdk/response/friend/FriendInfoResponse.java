package com.jinsulive.lagrange.sdk.response.friend;

import com.jinsulive.lagrange.sdk.response.AbstractResponse;
import com.jinsulive.lagrange.sdk.response.friend.data.FriendInfoData;

/**
 * @author lxy
 * @since 2024年09月11日 15:11:05
 */
public class FriendInfoResponse extends AbstractResponse {

    private FriendInfoData data;

    public FriendInfoResponse() {
    }

    public FriendInfoData getData() {
        return data;
    }

    public void setData(FriendInfoData data) {
        this.data = data;
    }

}
