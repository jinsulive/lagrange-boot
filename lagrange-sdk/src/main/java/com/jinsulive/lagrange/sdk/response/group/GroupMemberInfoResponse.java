package com.jinsulive.lagrange.sdk.response.group;

import com.jinsulive.lagrange.sdk.response.AbstractResponse;
import com.jinsulive.lagrange.sdk.response.group.data.GroupMemberInfoData;

/**
 * @author lxy
 * @since 2024年09月11日 14:08:39
 */
public class GroupMemberInfoResponse extends AbstractResponse {

    private GroupMemberInfoData data;


    public GroupMemberInfoResponse() {
    }

    public GroupMemberInfoData getData() {
        return data;
    }

    public void setData(GroupMemberInfoData data) {
        this.data = data;
    }


}
