package com.jinsulive.lagrange.sdk.response.other;

import com.jinsulive.lagrange.sdk.response.AbstractResponse;
import com.jinsulive.lagrange.sdk.response.other.data.GetImageData;

/**
 * @author lxy
 * @since 2024年09月11日 16:01:43
 */
public class GetImageResponse extends AbstractResponse {

    private GetImageData data;

    public GetImageResponse() {
    }

    public GetImageData getData() {
        return data;
    }

    public void setData(GetImageData data) {
        this.data = data;
    }

}
