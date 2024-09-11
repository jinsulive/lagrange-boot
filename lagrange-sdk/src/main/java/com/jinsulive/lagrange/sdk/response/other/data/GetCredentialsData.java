package com.jinsulive.lagrange.sdk.response.other.data;

import cn.hutool.json.JSONUtil;

/**
 * @author lxy
 * @since 2024年09月11日 15:54:21
 */
public class GetCredentialsData {
    /**
     * cookies
     */
    private String cookies;

    /**
     * CSRF Token
     */
    private Integer token;

    public GetCredentialsData() {
    }

    public String getCookies() {
        return cookies;
    }

    public void setCookies(String cookies) {
        this.cookies = cookies;
    }

    public Integer getToken() {
        return token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

}
