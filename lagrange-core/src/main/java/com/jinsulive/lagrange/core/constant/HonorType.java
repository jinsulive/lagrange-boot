package com.jinsulive.lagrange.core.constant;

import java.util.Arrays;
import java.util.Objects;

/**
 * 荣誉类型
 *
 * @author lxy
 * @since 2024年09月08日 02:24:05
 */
public enum HonorType {

    /**
     * 龙王
     */
    TALKATIVE("talkative"),
    /**
     * 群聊之火
     */
    PERFORMER("performer"),
    /**
     * 群聊炽焰
     */
    LEGEND("legend"),
    /**
     * 快乐源泉
     */
    EMOTION("emotion"),
    /**
     * null
     */
    NULL(null),

    /**
     * all
     */
    ALL("all");

    private final String value;

    HonorType(String value) {
        this.value = value;
    }

    public static HonorType convert(String value) {
        return Arrays.stream(values())
                .filter(item -> Objects.equals(item.getValue(), value))
                .findFirst().orElse(NULL);
    }

    public String getValue() {
        return value;
    }

}
