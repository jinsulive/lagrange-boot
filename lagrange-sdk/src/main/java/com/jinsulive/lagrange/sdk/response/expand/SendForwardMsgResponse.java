package com.jinsulive.lagrange.sdk.response.expand;

import com.jinsulive.lagrange.sdk.response.AbstractResponse;

/**
 * 构造合并转发消息响应
 *
 * @author lxy
 * @since 2024年09月17日 01:22:03
 */
public class SendForwardMsgResponse extends AbstractResponse {
    private String data;

    public SendForwardMsgResponse() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
