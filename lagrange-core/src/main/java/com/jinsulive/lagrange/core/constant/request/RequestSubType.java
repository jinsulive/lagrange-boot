package com.jinsulive.lagrange.core.constant.request;

import java.util.Arrays;
import java.util.Objects;

/**
 * 请求事件-请求子类型
 *
 * @author lxy
 * @since 2024年09月08日 03:19:50
 */
public enum RequestSubType {

    /**
     * 加群请求
     */
    ADD("add"),

    /**
     * 邀请登录号入群
     */
    INVITE("invite"),
    /**
     * null
     */
    NULL(null);

    private final String value;

    RequestSubType(String value) {
        this.value = value;
    }

    public static RequestSubType convert(String value) {
        return Arrays.stream(values())
                .filter(item -> Objects.equals(item.getValue(), value))
                .findFirst().orElse(null);
    }

    public String getValue() {
        return value;
    }

}
