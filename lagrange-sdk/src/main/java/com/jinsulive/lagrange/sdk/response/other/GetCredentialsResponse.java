package com.jinsulive.lagrange.sdk.response.other;

import com.jinsulive.lagrange.sdk.response.AbstractResponse;
import com.jinsulive.lagrange.sdk.response.other.data.GetCredentialsData;

/**
 * @author lxy
 * @since 2024年09月11日 15:53:47
 */
public class GetCredentialsResponse extends AbstractResponse {

    /**
     * 用于获取 cookie
     */
    private GetCredentialsData data;

    public GetCredentialsResponse() {
    }

    public GetCredentialsData getData() {
        return data;
    }

    public void setData(GetCredentialsData data) {
        this.data = data;
    }
}
