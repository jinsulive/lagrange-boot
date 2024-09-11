package com.jinsulive.lagrange.sdk.response.other;

import com.jinsulive.lagrange.sdk.response.AbstractResponse;
import com.jinsulive.lagrange.sdk.response.other.data.CanSendData;

/**
 * @author lxy
 * @since 2024年09月11日 16:06:02
 */
public class CanSendResponse extends AbstractResponse {

    private CanSendData data;

    public CanSendResponse() {
    }

    public CanSendData getData() {
        return data;
    }

    public void setData(CanSendData data) {
        this.data = data;
    }

}
