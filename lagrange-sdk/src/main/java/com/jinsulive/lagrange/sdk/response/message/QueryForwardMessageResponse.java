package com.jinsulive.lagrange.sdk.response.message;

import com.jinsulive.lagrange.sdk.response.AbstractResponse;
import com.jinsulive.lagrange.sdk.response.message.data.ForwardMessageData;

/**
 * @author lxy
 * @since 2024年09月13日 14:37:16
 */
public class QueryForwardMessageResponse extends AbstractResponse {

    private ForwardMessageData data;

    public QueryForwardMessageResponse() {
    }

    public ForwardMessageData getData() {
        return data;
    }

    public void setData(ForwardMessageData data) {
        this.data = data;
    }

}
