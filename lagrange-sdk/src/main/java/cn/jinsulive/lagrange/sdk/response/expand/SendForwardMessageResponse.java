package cn.jinsulive.lagrange.sdk.response.expand;

import cn.jinsulive.lagrange.sdk.response.AbstractResponse;
import cn.jinsulive.lagrange.sdk.response.expand.data.SendForwardMsgData;

/**
 * 构造合并转发消息响应(群聊/私聊)
 *
 * @author lxy
 * @since 2024年09月17日 02:46:03
 */
public class SendForwardMessageResponse extends AbstractResponse {

    private SendForwardMsgData data;

    public SendForwardMessageResponse() {
    }

    public SendForwardMsgData getData() {
        return data;
    }

    public void setData(SendForwardMsgData data) {
        this.data = data;
    }
}
