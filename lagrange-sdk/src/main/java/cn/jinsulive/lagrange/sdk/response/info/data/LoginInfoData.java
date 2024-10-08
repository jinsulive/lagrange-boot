package cn.jinsulive.lagrange.sdk.response.info.data;

import cn.hutool.json.JSONUtil;

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

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

}
