package cn.jinsulive.lagrange.core.constant;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author lxy
 * @since 2024年03月07日 10:19:49
 */
public enum SexType {

    MALE("male"),
    FEMALE("female"),
    UNKNOWN("unknown");

    private final String type;

    SexType(String type) {
        this.type = type;
    }

    public static SexType convert(String type) {
        return Arrays.stream(SexType.values())
                .filter(postType -> Objects.equals(postType.getType(), type))
                .findFirst().orElse(UNKNOWN);
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }

}
