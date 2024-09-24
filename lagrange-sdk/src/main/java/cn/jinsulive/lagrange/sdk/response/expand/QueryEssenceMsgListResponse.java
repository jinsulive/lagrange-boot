package cn.jinsulive.lagrange.sdk.response.expand;

import cn.jinsulive.lagrange.sdk.response.AbstractResponse;
import cn.jinsulive.lagrange.sdk.response.expand.data.EssenceMessageData;

import java.util.List;

/**
 * 查询精华消息列表响应
 *
 * @author lxy
 * @since 2024年09月13日 13:59:32
 */
public class QueryEssenceMsgListResponse extends AbstractResponse {

    private List<EssenceMessageData> data;

    public QueryEssenceMsgListResponse() {
    }

    public List<EssenceMessageData> getData() {
        return data;
    }

    public void setData(List<EssenceMessageData> data) {
        this.data = data;
    }

}
