package com.jinsulive.lagrange.sdk.response.group;

import com.jinsulive.lagrange.sdk.response.AbstractResponse;
import com.jinsulive.lagrange.sdk.response.group.data.GroupHonorInfoData;

/**
 * @author lxy
 * @since 2024年09月11日 15:34:48
 */
public class GroupHonorInfoResponse extends AbstractResponse {

    public GroupHonorInfoData data;

    public GroupHonorInfoResponse() {
    }

    public GroupHonorInfoData getData() {
        return data;
    }

    public void setData(GroupHonorInfoData data) {
        this.data = data;
    }

}