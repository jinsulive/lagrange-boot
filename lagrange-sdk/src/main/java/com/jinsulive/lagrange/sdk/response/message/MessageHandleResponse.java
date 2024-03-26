package com.jinsulive.lagrange.sdk.response.message;

import com.jinsulive.lagrange.sdk.response.AbstractResponse;
import com.jinsulive.lagrange.sdk.response.message.data.MessageHandleData;

/**
 * 发送/撤销
 *
 * @author lxy
 * @since 2024年03月15日 14:20:48
 */
public class MessageHandleResponse extends AbstractResponse {

    private MessageHandleData data;

    public MessageHandleData getData() {
        return data;
    }

    public void setData(MessageHandleData data) {
        this.data = data;
    }

}
