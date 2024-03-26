package com.jinsulive.lagrange.sdk.response.info.data;

/**
 * @author lxy
 * @since 2024年03月21日 15:21:11
 */
public class StrangerInfoData {

    private Long userId;
    private String nickname;
    private String sex;
    private Long age;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
