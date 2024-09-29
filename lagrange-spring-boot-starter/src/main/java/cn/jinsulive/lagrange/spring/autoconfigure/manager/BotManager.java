package cn.jinsulive.lagrange.spring.autoconfigure.manager;

import cn.jinsulive.lagrange.sdk.LagrangeBotClient;
import cn.jinsulive.lagrange.spring.autoconfigure.client.LagrangeBotWebSocketClient;
import cn.jinsulive.lagrange.spring.autoconfigure.util.SpringUtil;

/**
 * @author lxy
 * @since 2024年09月29日 11:06:49
 */
public class BotManager {

    public static LagrangeBotClient getSdkClient(Long botId) {
        String lagrangeBotClientName = LagrangeBotClient.class.getName() + "." + botId;
        return SpringUtil.getBean(lagrangeBotClientName);
    }

    public static LagrangeBotWebSocketClient getWebSocketClient(Long botId) {
        String name = LagrangeBotWebSocketClient.class.getName() + "." + botId;
        return SpringUtil.getBean(name);
    }
}
