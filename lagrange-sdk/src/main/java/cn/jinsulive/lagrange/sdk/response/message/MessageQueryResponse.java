package cn.jinsulive.lagrange.sdk.response.message;

import cn.jinsulive.lagrange.sdk.response.AbstractResponse;
import cn.jinsulive.lagrange.sdk.response.message.data.MessageQueryData;

/**
 * @author lxy
 * @since 2024年03月20日 21:55:09
 */
public class MessageQueryResponse extends AbstractResponse {

    private MessageQueryData data;

    public MessageQueryResponse() {
    }

    public MessageQueryData getData() {
        return data;
    }

    public void setData(MessageQueryData data) {
        this.data = data;
    }

}
