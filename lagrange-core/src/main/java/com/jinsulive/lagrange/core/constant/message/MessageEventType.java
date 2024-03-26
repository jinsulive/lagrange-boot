package com.jinsulive.lagrange.core.constant.message;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author lxy
 * @since 2024年03月06日 22:46:29
 */
public enum MessageEventType {

    PRIVATE("private"),

    GROUP("group");

    private final String type;

    MessageEventType(String type) {
        this.type = type;
    }

    public static MessageEventType convert(String type) {
        return Arrays.stream(MessageEventType.values())
                .filter(messageEventType -> Objects.equals(messageEventType.getType(), type))
                .findFirst().orElse(null);
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }

}
