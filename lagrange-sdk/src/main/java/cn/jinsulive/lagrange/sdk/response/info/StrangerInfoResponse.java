package cn.jinsulive.lagrange.sdk.response.info;

import cn.jinsulive.lagrange.sdk.response.AbstractResponse;
import cn.jinsulive.lagrange.sdk.response.info.data.StrangerInfoData;

/**
 * @author lxy
 * @since 2024年03月21日 15:20:45
 */
public class StrangerInfoResponse extends AbstractResponse {

    private StrangerInfoData data;

    public StrangerInfoResponse() {
    }

    public StrangerInfoData getData() {
        return data;
    }

    public void setData(StrangerInfoData data) {
        this.data = data;
    }

}
