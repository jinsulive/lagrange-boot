package cn.jinsulive.lagrange.sdk;

import cn.jinsulive.lagrange.sdk.request.AbstractRequest;
import cn.jinsulive.lagrange.sdk.response.AbstractResponse;

/**
 * Lagrange Bot 客户端
 *
 * @author lxy
 * @since 2024年03月15日 10:45:14
 */
public interface LagrangeBotClient {

    <T extends AbstractResponse> T execute(AbstractRequest<T> request) throws Exception;

}
