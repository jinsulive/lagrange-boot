package cn.jinsulive.lagrange.sdk.response.expand;

import cn.jinsulive.lagrange.sdk.response.AbstractResponse;
import cn.jinsulive.lagrange.sdk.response.expand.data.QueryMsgHistoryData;

/**
 * 历史消息列表
 *
 * @author lxy
 * @since 2024年09月12日 17:22:34
 */
public class QueryMsgHistoryResponse extends AbstractResponse {

    private QueryMsgHistoryData data;

    public QueryMsgHistoryResponse() {
    }

    public QueryMsgHistoryData getData() {
        return data;
    }

    public void setData(QueryMsgHistoryData data) {
        this.data = data;
    }
}
