package com.jinsulive.lagrange.sdk.response.other.data;

import cn.hutool.json.JSONUtil;

/**
 * @author lxy
 * @since 2024年09月11日 15:48:50
 */
public class GetCsrfTokenData {

    /**
     * CSRF Token
     */
    private Integer token;

    public GetCsrfTokenData() {
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
