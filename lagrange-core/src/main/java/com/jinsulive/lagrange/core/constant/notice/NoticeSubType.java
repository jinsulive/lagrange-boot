package com.jinsulive.lagrange.core.constant.notice;

import java.util.Arrays;
import java.util.Objects;

/**
 * 通知事件-提示类型
 *
 * @author lxy
 * @since 2024年09月08日 02:23:20
 */
public enum NoticeSubType {
    /**
     * 群管理员变动-设置管理员
     */
    SET("set"),
    /**
     * 群管理员变动-取消管理员
     */
    UNSET("unset"),
    /**
     * 群成员减少-主动退群
     */
    LEAVE("leave"),
    /**
     * 群成员减少-成员被踢
     */
    KICK("kick"),
    /**
     * 群成员减少-登录号被踢
     */
    KICK_ME("kick_me"),
    /**
     * 群成员增加-管理员已同意入群
     */
    APPROVE("approve"),
    /**
     * 群成员增加-管理员邀请入群
     */
    INVITE("invite"),
    /**
     * 群禁言
     */
    BAN("ban"),
    /**
     * 群禁言-解除禁言
     */
    LIFT_BAN("lift_ban"),
    /**
     * 群内戳一戳
     */
    POKE("poke"),
    /**
     * 群红包运气王
     */
    LUCKY_KING("lucky_king"),
    /**
     * 群成员荣誉变更
     */
    HONOR("honor"),
    /**
     * 精华消息添加
     */
    ADD("add"),
    /**
     * 精华消息删除
     */
    DELETE("delete"),
    /**
     * null
     */
    NULL(null);

    private final String value;

    NoticeSubType(String value) {
        this.value = value;
    }

    public static NoticeSubType convert(String value) {
        return Arrays.stream(values())
                .filter(item -> Objects.equals(item.getValue(), value))
                .findFirst().orElse(NULL);
    }

    public String getValue() {
        return value;
    }

}
