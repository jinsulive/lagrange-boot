package com.jinsulive.lagrange.core.constant.message.data;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author lxy
 * @since 2024年03月06日 23:32:26
 */
@Getter
public enum ContactType {

    QQ("qq"),
    GROUP("group");

    private final String type;

    ContactType(String type) {
        this.type = type;
    }

    public static ContactType convert(String type) {
        return Arrays.stream(ContactType.values())
                .filter(postType -> Objects.equals(postType.getType(), type))
                .findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return type;
    }

}
