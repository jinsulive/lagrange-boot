package cn.jinsulive.lagrange.core.constant.message.data;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author lxy
 * @since 2024年03月06日 23:38:00
 */
public enum MusicType {

    CUSTOM("custom"),
    QQ("qq"),
    NET_EASE_CLOUD_MUSIC("163"),
    XM("xm");

    private final String type;

    MusicType(String type) {
        this.type = type;
    }

    public static MusicType convert(String type) {
        return Arrays.stream(MusicType.values())
                .filter(musicType -> Objects.equals(musicType.getType(), type))
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
