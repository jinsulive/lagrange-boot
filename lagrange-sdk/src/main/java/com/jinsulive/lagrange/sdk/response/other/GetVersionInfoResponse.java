package com.jinsulive.lagrange.sdk.response.other;

import com.jinsulive.lagrange.sdk.response.AbstractResponse;
import com.jinsulive.lagrange.sdk.response.other.data.GetVersionInfoData;

/**
 * @author lxy
 * @since 2024年09月11日 16:21:29
 */
public class GetVersionInfoResponse extends AbstractResponse {

    private GetVersionInfoData data;

    public GetVersionInfoResponse() {
    }

    public GetVersionInfoData getData() {
        return data;
    }

    public void setData(GetVersionInfoData data) {
        this.data = data;
    }
}
