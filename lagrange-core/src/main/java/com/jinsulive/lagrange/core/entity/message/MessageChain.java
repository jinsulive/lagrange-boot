package com.jinsulive.lagrange.core.entity.message;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.core.constant.message.MessageType;
import com.jinsulive.lagrange.core.entity.message.data.*;

import java.lang.Record;
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

    public MessageChain at(At at) {
        Message message = Message.builder().
                type(MessageType.AT)
                .data(at)
                .build();
        messages.add(message);
        return this;
    }

    public MessageChain contact(Contact contact) {
        Message message = Message.builder().
                type(MessageType.CONTACT)
                .data(contact)
                .build();
        messages.add(message);
        return this;
    }

    public MessageChain face(Face face) {
        Message message = Message.builder().
                type(MessageType.CONTACT)
                .data(face)
                .build();
        messages.add(message);
        return this;
    }

    public MessageChain forward(Forward forward) {
        Message message = Message.builder().
                type(MessageType.CONTACT)
                .data(forward)
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

    public MessageChain json(Json json) {
        Message message = Message.builder().
                type(MessageType.JSON)
                .data(json)
                .build();
        messages.add(message);
        return this;
    }

    public MessageChain location(Location location) {
        Message message = Message.builder().
                type(MessageType.LOCATION)
                .data(location)
                .build();
        messages.add(message);
        return this;
    }

    public MessageChain markdown(Markdown markdown) {
        Message message = Message.builder().
                type(MessageType.MARKDOWN)
                .data(markdown)
                .build();
        messages.add(message);
        return this;
    }

    public MessageChain music(Music music) {
        Message message = Message.builder().
                type(MessageType.MUSIC)
                .data(music)
                .build();
        messages.add(message);
        return this;
    }


    public MessageChain node(Node node) {
        Message message = Message.builder().
                type(MessageType.NODE)
                .data(node)
                .build();
        messages.add(message);
        return this;
    }

    public MessageChain reply(Reply reply) {
        // 回复的引用消息只能有一条
        boolean match = messages.stream().anyMatch(message -> message.getType() == MessageType.REPLY);
        if (match) {
            throw new IllegalArgumentException("Reply message can only have one message.");
        }
        Message message = Message.builder().
                type(MessageType.REPLY)
                .data(reply)
                .build();
        messages.add(message);
        return this;
    }

    public MessageChain share(Share share) {
        Message message = Message.builder().
                type(MessageType.SHARE)
                .data(share)
                .build();
        messages.add(message);
        return this;
    }

    public MessageChain text(Text text) {
        Message message = Message.builder().
                type(MessageType.TEXT)
                .data(text)
                .build();
        messages.add(message);
        return this;
    }

    public MessageChain video(Video video) {
        Message message = Message.builder().
                type(MessageType.VIDEO)
                .data(video)
                .build();
        messages.add(message);
        return this;
    }

    public MessageChain xml(Xml xml) {
        Message message = Message.builder().
                type(MessageType.XML)
                .data(xml)
                .build();
        messages.add(message);
        return this;
    }

    public MessageChain record(Record record) {
        Message message = Message.builder().
                type(MessageType.RECORD)
                .data(record)
                .build();
        messages.add(message);
        return this;
    }

    public MessageChain blankSpace() {
        Message message = Message.builder().
                type(MessageType.TEXT)
                .data(Text.builder().text(" ").build())
                .build();
        messages.add(message);
        return this;
    }

    public MessageChain lineBreak() {
        Message message = Message.builder().
                type(MessageType.TEXT)
                .data(Text.builder().text("\n").build())
                .build();
        messages.add(message);
        return this;
    }

    public List<Message> get() {
        return messages;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(messages);
    }

}
