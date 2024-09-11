package com.jinsulive.lagrange.sdk.response.other;

import com.jinsulive.lagrange.sdk.response.AbstractResponse;
import com.jinsulive.lagrange.sdk.response.other.data.GetCsrfTokenData;

/**
 * @author lxy
 * @since 2024年09月11日 15:48:10
 */
public class GetCsrfTokenResponse extends AbstractResponse {
    private GetCsrfTokenData data;

    public GetCsrfTokenResponse() {
    }

    public GetCsrfTokenData getData() {
        return data;
    }

    public void setData(GetCsrfTokenData data) {
        this.data = data;
    }

}
