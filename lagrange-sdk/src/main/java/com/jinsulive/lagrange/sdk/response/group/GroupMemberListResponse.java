package com.jinsulive.lagrange.sdk.response.group;

import com.jinsulive.lagrange.sdk.response.AbstractResponse;
import com.jinsulive.lagrange.sdk.response.group.data.GroupMemberInfoData;

import java.util.List;

/**
 * @author lxy
 * @since 2024年09月11日 15:22:52
 */
public class GroupMemberListResponse extends AbstractResponse {

    private List<GroupMemberInfoData> data;

    public GroupMemberListResponse() {
    }

    public List<GroupMemberInfoData> getData() {
        return data;
    }

    public void setData(List<GroupMemberInfoData> data) {
        this.data = data;
    }
}
