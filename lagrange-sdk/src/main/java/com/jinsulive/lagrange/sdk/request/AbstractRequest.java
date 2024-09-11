package com.jinsulive.lagrange.sdk.request;

import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.sdk.response.AbstractResponse;

/**
 * @author lxy
 * @since 2024年03月15日 10:47:11
 */
public abstract class AbstractRequest<T extends AbstractResponse> {

    public abstract String getServiceUrl();

    public abstract String getJsonParamString();

    public abstract Class<T> getResponseClass();

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

}
