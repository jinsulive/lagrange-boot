package com.jinsulive.lagrange.core.constant.message;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author lxy
 * @since 2024年03月07日 10:19:49
 */
public enum SenderSexType {

    MALE("male"),
    FEMALE("female"),
    UNKNOWN("unknown");

    private final String type;

    SenderSexType(String type) {
        this.type = type;
    }

    public static SenderSexType convert(String type) {
        return Arrays.stream(SenderSexType.values())
                .filter(postType -> Objects.equals(postType.getType(), type))
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
