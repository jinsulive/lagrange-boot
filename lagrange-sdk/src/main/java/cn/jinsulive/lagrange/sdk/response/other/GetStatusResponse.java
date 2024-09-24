package cn.jinsulive.lagrange.sdk.response.other;

import cn.jinsulive.lagrange.sdk.response.AbstractResponse;
import cn.jinsulive.lagrange.sdk.response.other.data.GetStatusData;

/**
 * @author lxy
 * @since 2024年09月11日 16:11:40
 */
public class GetStatusResponse extends AbstractResponse {

    private GetStatusData data;

    public GetStatusResponse() {
    }

    public GetStatusData getData() {
        return data;
    }

    public void setData(GetStatusData data) {
        this.data = data;
    }
}
