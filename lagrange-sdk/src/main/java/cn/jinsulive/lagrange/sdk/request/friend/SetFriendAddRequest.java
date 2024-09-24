package cn.jinsulive.lagrange.sdk.request.friend;

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
public class SetFriendAddRequest extends AbstractRequest<EmptyResponse> {

    /**
     * 加好友请求的 flag（需从上报的数据中获得）
     */
    private String flag;
    /**
     * 是否同意请求
     */
    private Boolean approve = true;
    /**
     * 添加后的好友备注（仅在同意时有效）
     */
    private String remark;

    public SetFriendAddRequest() {
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Boolean getApprove() {
        return approve;
    }

    public void setApprove(Boolean approve) {
        this.approve = approve;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String getServiceUrl() {
        return "set_friend_add_request";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("flag", flag)
                .putOpt("approve", approve)
                .putOpt("remark", remark);
    }

    @Override
    public Class<EmptyResponse> getResponseClass() {
        return EmptyResponse.class;
    }
}
