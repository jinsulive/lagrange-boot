package com.jinsulive.lagrange.sdk.response.other;

import com.jinsulive.lagrange.sdk.response.AbstractResponse;
import com.jinsulive.lagrange.sdk.response.other.data.GetRecordData;

/**
 * @author lxy
 * @since 2024年09月11日 15:58:28
 */
public class GetRecordResponse extends AbstractResponse {

    private GetRecordData data;

    public GetRecordResponse() {
    }

    public GetRecordData getData() {
        return data;
    }

    public void setData(GetRecordData data) {
        this.data = data;
    }
}
