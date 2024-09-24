package cn.jinsulive.lagrange.sdk.response.other.data;

import cn.hutool.json.JSONUtil;

/**
 * @author lxy
 * @since 2024年09月11日 16:06:35
 */
public class CanSendData {

    /**
     * 是或否
     */
    private Boolean yes;

    public CanSendData() {
    }

    public Boolean getYes() {
        return yes;
    }

    public void setYes(Boolean yes) {
        this.yes = yes;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

}
