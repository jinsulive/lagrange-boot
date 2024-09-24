package cn.jinsulive.lagrange.core.constant;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author lxy
 * @since 2024年03月07日 10:16:08
 */
public enum RoleType {

    ADMIN("admin"),
    MEMBER("member"),
    OWNER("owner");

    private final String type;

    RoleType(String type) {
        this.type = type;
    }

    public static RoleType convert(String type) {
        return Arrays.stream(RoleType.values())
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
