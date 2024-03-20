package com.jinsulive.lagrange.core.constant.message;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author lxy
 * @since 2024年03月07日 10:06:14
 */
@Getter
public enum MessageSubType {

    GROUP_NORMAL("normal"),
    GROUP_ANONYMOUS("anonymous"),
    GROUP_NOTICE("notice"),
    PRIVATE_FRIEND("friend"),
    PRIVATE_GROUP("group"),
    PRIVATE_OTHER("other");

    private final String type;

    MessageSubType(String type) {
        this.type = type;
    }

    public static MessageSubType convert(String type) {
        return Arrays.stream(MessageSubType.values())
                .filter(postType -> Objects.equals(postType.getType(), type))
                .findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return type;
    }

}
