package com.jinsulive.lagrange.sdk.response.other.data;

import cn.hutool.json.JSONUtil;

/**
 * @author lxy
 * @since 2024年09月11日 15:45:53
 */
public class GetCookiesData {

    /**
     * cookies
     */
    private String cookies;

    public String getCookies() {
        return cookies;
    }

    public void setCookies(String cookies) {
        this.cookies = cookies;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

}
