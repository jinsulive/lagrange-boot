package cn.jinsulive.lagrange.sdk.response.friend;

import cn.jinsulive.lagrange.sdk.response.AbstractResponse;
import cn.jinsulive.lagrange.sdk.response.friend.data.FriendInfoData;

import java.util.List;

/**
 * @author lxy
 * @since 2024年09月11日 15:11:05
 */
public class FriendInfoResponse extends AbstractResponse {

    private List<FriendInfoData> data;

    public FriendInfoResponse() {
    }

    public List<FriendInfoData> getData() {
        return data;
    }

    public void setData(List<FriendInfoData> data) {
        this.data = data;
    }

}
