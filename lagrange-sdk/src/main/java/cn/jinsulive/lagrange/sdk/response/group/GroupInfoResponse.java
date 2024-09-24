package cn.jinsulive.lagrange.sdk.response.group;

import cn.jinsulive.lagrange.sdk.response.AbstractResponse;
import cn.jinsulive.lagrange.sdk.response.group.data.GroupInfoData;

/**
 * @author lxy
 * @since 2024年09月11日 15:14:49
 */
public class GroupInfoResponse extends AbstractResponse {

    private GroupInfoData data;


    public GroupInfoResponse() {
    }

    public GroupInfoData getData() {
        return data;
    }

    public void setData(GroupInfoData data) {
        this.data = data;
    }

}
