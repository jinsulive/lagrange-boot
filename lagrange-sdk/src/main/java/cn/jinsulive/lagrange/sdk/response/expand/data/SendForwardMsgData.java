package cn.jinsulive.lagrange.sdk.response.expand.data;

import cn.hutool.json.JSONUtil;

/**
 * @author lxy
 * @since 2024年09月17日 01:23:34
 */
public class SendForwardMsgData {

    private String messageId;
    private String forwardId;

    public SendForwardMsgData() {
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getForwardId() {
        return forwardId;
    }

    public void setForwardId(String forwardId) {
        this.forwardId = forwardId;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

}
