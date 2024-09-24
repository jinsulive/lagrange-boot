package cn.jinsulive.lagrange.core.constant;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author lxy
 * @since 2024年03月06日 11:41:59
 */
public enum PostType {

    MESSAGE("message"),
    NOTICE("notice"),
    REQUEST("request"),
    META_EVENT("meta_event");

    private final String type;

    PostType(String type) {
        this.type = type;
    }

    public static PostType convert(String type) {
        return Arrays.stream(PostType.values())
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
