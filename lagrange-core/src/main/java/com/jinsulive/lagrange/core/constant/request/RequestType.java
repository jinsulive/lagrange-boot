package com.jinsulive.lagrange.core.constant.request;

import java.util.Arrays;
import java.util.Objects;

/**
 * 请求事件
 *
 * @author lxy
 * @since 2024年09月08日 03:18:13
 */
public enum RequestType {

    /**
     * 加好友请求
     */
    FRIEND("friend"),

    /**
     * 加群请求／邀请
     */
    GROUP("group"),
    /**
     * null
     */
    NULL(null);

    private final String value;

    RequestType(String value) {
        this.value = value;
    }

    public static RequestType convert(String value) {
        return Arrays.stream(values())
                .filter(item -> Objects.equals(item.getValue(), value))
                .findFirst().orElse(null);
    }

    public String getValue() {
        return value;
    }

}
