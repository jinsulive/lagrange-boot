package com.jinsulive.lagrange.sdk.response.message.data;

import cn.hutool.json.JSONUtil;

/**
 * @author lxy
 * @since 2024年03月15日 14:25:50
 */
public class MessageHandleData {

    private Long messageId;

    public MessageHandleData() {
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

}
