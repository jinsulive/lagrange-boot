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

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

}
