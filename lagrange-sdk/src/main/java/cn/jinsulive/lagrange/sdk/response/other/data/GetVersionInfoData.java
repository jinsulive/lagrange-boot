package cn.jinsulive.lagrange.sdk.response.other.data;

import cn.hutool.json.JSONUtil;

/**
 * @author lxy
 * @since 2024年09月11日 16:23:23
 */
public class GetVersionInfoData {

    /**
     * 应用标识
     */
    private String ppName;
    /**
     * 应用版本
     */
    private String appVersion;
    /**
     * OneBot 标准版本，如 v11
     */
    private String protocolVersion;

    /**
     * nt 协议版本
     */
    private String ntProtocol;

    public GetVersionInfoData() {
    }

    public String getPpName() {
        return ppName;
    }

    public void setPpName(String ppName) {
        this.ppName = ppName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public String getNtProtocol() {
        return ntProtocol;
    }

    public void setNtProtocol(String ntProtocol) {
        this.ntProtocol = ntProtocol;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

}
