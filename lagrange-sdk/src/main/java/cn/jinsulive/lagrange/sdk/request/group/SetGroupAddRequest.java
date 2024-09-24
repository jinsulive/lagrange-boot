package cn.jinsulive.lagrange.sdk.request.group;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.sdk.request.AbstractRequest;
import cn.jinsulive.lagrange.sdk.response.EmptyResponse;

/**
 * 处理加群请求／邀请
 *
 * @author lxy
 * @since 2024年09月11日 15:03:39
 */
public class SetGroupAddRequest extends AbstractRequest<EmptyResponse> {

    /**
     * 加群请求的 flag（需从上报的数据中获得）
     */
    private String flag;
    /**
     * 请求类型 add 或 invite（需要和上报消息中的 sub_type 字段相符）
     */
    private String subType;
    /**
     * 是否同意请求／邀请
     */
    private Boolean approve = true;
    /**
     * 拒绝理由（仅在拒绝时有效）
     */
    private String reason;

    public SetGroupAddRequest() {
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public Boolean getApprove() {
        return approve;
    }

    public void setApprove(Boolean approve) {
        this.approve = approve;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String getServiceUrl() {
        return "set_group_add_request";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("flag", flag)
                .putOpt("sub_type", subType)
                .putOpt("approve", approve)
                .putOpt("reason", reason);
    }

    @Override
    public Class<EmptyResponse> getResponseClass() {
        return EmptyResponse.class;
    }
}
