package com.jinsulive.lagrange.sdk;

import com.jinsulive.lagrange.sdk.request.LagrangeBotRequest;
import com.jinsulive.lagrange.sdk.response.AbstractResponse;

/**
 * Lagrange Bot 客户端
 *
 * @author lxy
 * @since 2024年03月15日 10:45:14
 */
public interface LagrangeBotClient {

    <T extends AbstractResponse> T execute(LagrangeBotRequest<T> request) throws Exception;

}
