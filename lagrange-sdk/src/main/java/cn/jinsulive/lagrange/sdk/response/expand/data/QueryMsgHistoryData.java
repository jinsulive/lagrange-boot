package cn.jinsulive.lagrange.sdk.response.expand.data;

import cn.jinsulive.lagrange.core.event.message.MessageEvent;

import java.util.List;

/**
 * @author lxy
 * @since 2024年09月12日 17:30:49
 */
public class QueryMsgHistoryData {

    private List<MessageEvent> messages;

    public QueryMsgHistoryData() {
    }

    public List<MessageEvent> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageEvent> messages) {
        this.messages = messages;
    }
}
