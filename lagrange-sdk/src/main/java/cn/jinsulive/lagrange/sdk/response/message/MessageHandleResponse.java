package cn.jinsulive.lagrange.sdk.response.message;

import cn.jinsulive.lagrange.sdk.response.AbstractResponse;
import cn.jinsulive.lagrange.sdk.response.message.data.MessageHandleData;

/**
 * 发送/撤销
 *
 * @author lxy
 * @since 2024年03月15日 14:20:48
 */
public class MessageHandleResponse extends AbstractResponse {

    private MessageHandleData data;

    public MessageHandleResponse() {
    }

    public MessageHandleData getData() {
        return data;
    }

    public void setData(MessageHandleData data) {
        this.data = data;
    }

}
