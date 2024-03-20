package com.jinsulive.lagrange.sdk.request;

/**
 * @author lxy
 * @since 2024年03月15日 10:47:11
 */
public interface LagrangeBotRequest<T> {

    String getServiceUrl();

    String getJsonParamString();

    Class<T> getResponseClass();

}
