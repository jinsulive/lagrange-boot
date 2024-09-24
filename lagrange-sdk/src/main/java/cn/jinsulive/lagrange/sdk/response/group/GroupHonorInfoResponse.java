package cn.jinsulive.lagrange.sdk.response.group;

import cn.jinsulive.lagrange.sdk.response.AbstractResponse;
import cn.jinsulive.lagrange.sdk.response.group.data.GroupHonorInfoData;

/**
 * @author lxy
 * @since 2024年09月11日 15:34:48
 */
public class GroupHonorInfoResponse extends AbstractResponse {

    private GroupHonorInfoData data;

    public GroupHonorInfoResponse() {
    }

    public GroupHonorInfoData getData() {
        return data;
    }

    public void setData(GroupHonorInfoData data) {
        this.data = data;
    }

}
