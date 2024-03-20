package com.jinsulive.lagrange.core.constant.message;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author lxy
 * @since 2024年03月06日 22:33:46
 */
@Getter
public enum MessageType {

    TEXT("text"),
    FACE("face"),
    IMAGE("image"),
    RECORD("record"),
    VIDEO("video"),
    AT("at"),
    RPS("rps"),
    DICE("dice"),
    SHAKE("shake"),
    POKE("poke"),
    ANONYMOUS("anonymous"),
    SHARE("share"),
    CONTACT("contact"),
    LOCATION("location"),
    MUSIC("music"),
    REPLY("reply"),
    FORWARD("forward"),
    NODE("node"),
    XML("xml"),
    JSON("json"),
    MARKDOWN("markdown");

    private final String type;

    MessageType(String type) {
        this.type = type;
    }

    public static MessageType convert(String type) {
        return Arrays.stream(MessageType.values())
                .filter(messageType -> Objects.equals(messageType.getType(), type))
                .findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return type;
    }


}
