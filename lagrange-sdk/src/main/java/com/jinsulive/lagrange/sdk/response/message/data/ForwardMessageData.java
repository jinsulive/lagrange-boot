package com.jinsulive.lagrange.sdk.response.message.data;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.core.constant.message.MessageType;
import com.jinsulive.lagrange.core.entity.message.data.Node;

import java.util.List;

/**
 * @author lxy
 * @since 2024年09月13日 14:38:05
 */
public class ForwardMessageData {

    private List<NodeMessage> message;

    public ForwardMessageData() {
    }

    public List<NodeMessage> getMessage() {
        return message;
    }

    public void setMessage(List<NodeMessage> message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public static class NodeMessage {
        private MessageType type;

        private Node data;

        public NodeMessage() {
        }

        public MessageType getType() {
            return type;
        }

        public void setType(MessageType type) {
            this.type = type;
        }

        public Node getData() {
            return data;
        }

        public void setData(Node data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return JSONUtil.toJsonStr(this);
        }

    }
}
