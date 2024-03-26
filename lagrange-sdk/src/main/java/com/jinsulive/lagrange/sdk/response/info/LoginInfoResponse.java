package com.jinsulive.lagrange.sdk.response.info;

import com.jinsulive.lagrange.sdk.response.AbstractResponse;
import com.jinsulive.lagrange.sdk.response.info.data.LoginInfoData;

/**
 * @author lxy
 * @since 2024年03月21日 15:11:27
 */
public class LoginInfoResponse extends AbstractResponse {

    private LoginInfoData data;

    public LoginInfoResponse() {
    }

    public LoginInfoData getData() {
        return data;
    }

    public void setData(LoginInfoData data) {
        this.data = data;
    }
}
