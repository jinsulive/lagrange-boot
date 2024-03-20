package com.jinsulive.lagrange.core.constant.message;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author lxy
 * @since 2024年03月07日 10:16:08
 */
@Getter
public enum SenderRoleType {

    ADMIN("admin"),
    MEMBER("member"),
    OWNER("owner");

    private final String type;

    SenderRoleType(String type) {
        this.type = type;
    }

    public static SenderRoleType convert(String type) {
        return Arrays.stream(SenderRoleType.values())
                .filter(postType -> Objects.equals(postType.getType(), type))
                .findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return type;
    }

}
