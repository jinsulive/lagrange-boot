package com.jinsulive.lagrange.core.constant.notice;

import java.util.Arrays;
import java.util.Objects;

/**
 * 通知事件类型
 *
 * @author lxy
 * @since 2024年09月08日 02:17:52
 */
public enum NoticeType {
    /**
     * 群文件上传
     */
    GROUP_UPLOAD("group_upload"),
    /**
     * 群管理员变动
     */
    GROUP_ADMIN("group_admin"),
    /**
     * 群成员减少
     */
    GROUP_DECREASE("group_decrease"),
    /**
     * 群成员增加
     */
    GROUP_INCREASE("group_increase"),
    /**
     * 群禁言
     */
    GROUP_BAN("group_ban"),
    /**
     * 好友添加
     */
    FRIEND_ADD("friend_add"),
    /**
     * 群消息撤回
     */
    GROUP_RECALL("group_recall"),
    /**
     * 好友消息撤回
     */
    FRIEND_RECALL("friend_recall"),
    /**
     * 群内戳一戳 / 群红包运气王 / 群成员荣誉变更
     */
    NOTIFY("notify"),
    /**
     * 精华消息
     */
    ESSENCE("essence"),
    /**
     * null
     */
    NULL(null);

    private final String value;

    NoticeType(String value) {
        this.value = value;
    }

    public static NoticeType convert(String value) {
        return Arrays.stream(values())
                .filter(item -> Objects.equals(item.getValue(), value))
                .findFirst().orElse(NULL);
    }

    public String getValue() {
        return value;
    }

}
