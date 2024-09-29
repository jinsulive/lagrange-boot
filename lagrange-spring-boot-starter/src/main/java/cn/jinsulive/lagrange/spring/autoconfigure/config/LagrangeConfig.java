package cn.jinsulive.lagrange.spring.autoconfigure.config;

import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.spring.autoconfigure.entity.Bot;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * lagrange config
 *
 * @author lxy
 * @since 2024年03月06日 11:29:52
 */
@ConfigurationProperties(prefix = "lagrange")
public class LagrangeConfig {

    private List<Bot> bots;

    private boolean openDebugLog = false;

    private boolean openMataEventLog = false;

    private String lagrangeBotClient = "cn.jinsulive.lagrange.sdk.DefaultLagrangeBotClient";

    public LagrangeConfig() {
    }

    public List<Bot> getBots() {
        return bots;
    }

    public void setBots(List<Bot> bots) {
        this.bots = bots;
    }

    public boolean isOpenDebugLog() {
        return openDebugLog;
    }

    public void setOpenDebugLog(boolean openDebugLog) {
        this.openDebugLog = openDebugLog;
    }

    public boolean isOpenMataEventLog() {
        return openMataEventLog;
    }

    public void setOpenMataEventLog(boolean openMataEventLog) {
        this.openMataEventLog = openMataEventLog;
    }

    public String getLagrangeBotClient() {
        return lagrangeBotClient;
    }

    public void setLagrangeBotClient(String lagrangeBotClient) {
        this.lagrangeBotClient = lagrangeBotClient;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

}
