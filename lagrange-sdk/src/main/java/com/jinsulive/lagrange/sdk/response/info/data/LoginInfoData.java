package com.jinsulive.lagrange.sdk.response.info.data;

/**
 * @author lxy
 * @since 2024年03月21日 15:11:59
 */
public class LoginInfoData {

    private Long userId;

    private String nickname;

    public LoginInfoData() {
    }

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
}
