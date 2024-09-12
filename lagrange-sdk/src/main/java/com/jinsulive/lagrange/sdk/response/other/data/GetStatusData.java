package com.jinsulive.lagrange.sdk.response.other.data;

import cn.hutool.json.JSONUtil;

/**
 * @author lxy
 * @since 2024年09月11日 16:12:19
 */
public class GetStatusData {

    /**
     * 当前 QQ 在线，null 表示无法查询到在线状态
     */
    private Boolean online;
    /**
     * 状态符合预期，意味着各模块正常运行、功能正常，且 QQ 在线
     */
    private Boolean good;
    private Boolean appInitialized;
    private Boolean appEnabled;
    private Boolean pluginsGood;
    private Boolean appGood;
    private Long memory;

    public GetStatusData() {
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Boolean getGood() {
        return good;
    }

    public void setGood(Boolean good) {
        this.good = good;
    }

    public Boolean getAppInitialized() {
        return appInitialized;
    }

    public void setAppInitialized(Boolean appInitialized) {
        this.appInitialized = appInitialized;
    }

    public Boolean getAppEnabled() {
        return appEnabled;
    }

    public void setAppEnabled(Boolean appEnabled) {
        this.appEnabled = appEnabled;
    }

    public Boolean getPluginsGood() {
        return pluginsGood;
    }

    public void setPluginsGood(Boolean pluginsGood) {
        this.pluginsGood = pluginsGood;
    }

    public Boolean getAppGood() {
        return appGood;
    }

    public void setAppGood(Boolean appGood) {
        this.appGood = appGood;
    }

    public Long getMemory() {
        return memory;
    }

    public void setMemory(Long memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

}
