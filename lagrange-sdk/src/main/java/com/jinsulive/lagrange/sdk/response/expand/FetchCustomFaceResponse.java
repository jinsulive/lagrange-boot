package com.jinsulive.lagrange.sdk.response.expand;

import com.jinsulive.lagrange.sdk.response.AbstractResponse;

import java.util.List;

/**
 * @author lxy
 * @since 2024年09月12日 14:17:16
 */
public class FetchCustomFaceResponse extends AbstractResponse {

    private List<String> data;

    public FetchCustomFaceResponse() {
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

}
