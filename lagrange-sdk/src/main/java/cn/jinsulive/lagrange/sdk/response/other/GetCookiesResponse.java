package cn.jinsulive.lagrange.sdk.response.other;

import cn.jinsulive.lagrange.sdk.response.AbstractResponse;
import cn.jinsulive.lagrange.sdk.response.other.data.GetCookiesData;

/**
 * @author lxy
 * @since 2024年09月11日 15:45:29
 */
public class GetCookiesResponse extends AbstractResponse {

    private GetCookiesData data;

    public GetCookiesResponse() {
    }

    public GetCookiesData getData() {
        return data;
    }

    public void setData(GetCookiesData data) {
        this.data = data;
    }
}
