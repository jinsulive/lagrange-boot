package com.jinsulive.lagrange.core.entity.message;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.core.constant.message.MessageType;
import com.jinsulive.lagrange.core.entity.message.data.At;
import com.jinsulive.lagrange.core.entity.message.data.Image;
import com.jinsulive.lagrange.core.entity.message.data.Reply;
import com.jinsulive.lagrange.core.entity.message.data.Text;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lxy
 * @since 2024年03月15日 16:43:11
 */
public class MessageChain {

    private final List<Message> messages = new LinkedList<>();

    private MessageChain() {
    }

    public static MessageChain builder() {
        return new MessageChain();
    }

    public MessageChain at(String qq) {
        this.addPreBlankSpace();
        Message message = Message.builder().
                type(MessageType.AT)
                .data(At.builder().qq(qq).build())
                .build();
        messages.add(message);
        return this;
    }

    public MessageChain image(Image image) {
        Message message = Message.builder().
                type(MessageType.IMAGE)
                .data(image)
                .build();
        messages.add(message);
        return this;
    }

    public MessageChain reply(String messageId) {
        // 回复的引用消息只能有一条
        boolean match = messages.stream().anyMatch(message -> message.getType() == MessageType.REPLY);
        if (match) {
            throw new IllegalArgumentException("Reply message can only have one message.");
        }
        Message message = Message.builder().
                type(MessageType.REPLY)
                .data(Reply.builder().id(String.valueOf(messageId)).build())
                .build();
        messages.add(message);
        return this;
    }

    public MessageChain text(String text) {
        boolean preTypeIsAt = preTypeIsAt();
        Message message = Message.builder().
                type(MessageType.TEXT)
                .data(Text.builder().text(preTypeIsAt ? " " + text : text).build())
                .build();
        messages.add(message);
        return this;
    }

    private void addPreBlankSpace() {
        if (preTypeIsAt()) {
            Message message = Message.builder().
                    type(MessageType.TEXT)
                    .data(Text.builder().text(" ").build())
                    .build();
            messages.add(message);
        }
    }

    private boolean preTypeIsAt() {
        return !messages.isEmpty() && messages.get(messages.size() - 1).getType() == MessageType.AT;
    }

    public List<Message> get() {
        return messages;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(messages);
    }

}
