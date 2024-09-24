package cn.jinsulive.lagrange.sdk.response.group;

import cn.jinsulive.lagrange.sdk.response.AbstractResponse;
import cn.jinsulive.lagrange.sdk.response.group.data.GroupInfoData;

import java.util.List;

/**
 * @author lxy
 * @since 2024年09月11日 15:19:07
 */
public class GroupListResponse extends AbstractResponse {

    private List<GroupInfoData> data;


    public GroupListResponse() {
    }

    public List<GroupInfoData> getData() {
        return data;
    }

    public void setData(List<GroupInfoData> data) {
        this.data = data;
    }

}
