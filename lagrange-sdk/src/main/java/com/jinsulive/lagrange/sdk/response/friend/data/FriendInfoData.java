package com.jinsulive.lagrange.sdk.response.friend.data;

import cn.hutool.json.JSONUtil;

/**
 * @author lxy
 * @since 2024年09月11日 15:11:36
 */
public class FriendInfoData {

    /**
     * QQ号
     */
    private Long userId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 备注
     */
    private String remark;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

}
