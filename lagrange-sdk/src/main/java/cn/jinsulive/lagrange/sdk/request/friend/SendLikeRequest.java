package cn.jinsulive.lagrange.sdk.request.friend;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.sdk.request.AbstractRequest;
import cn.jinsulive.lagrange.sdk.response.EmptyResponse;

/**
 * @author lxy
 * @since 2024年09月11日 14:28:55
 */
public class SendLikeRequest extends AbstractRequest<EmptyResponse> {

    /**
     * 对方 QQ 号
     */
    private Long userId;

    /**
     * 赞的次数，每个好友每天最多 10 次
     */
    private Integer times;

    public SendLikeRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    @Override
    public String getServiceUrl() {
        return "send_like";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("user_id", userId)
                .putOpt("times", Math.min(times, 10));
    }

    @Override
    public Class<EmptyResponse> getResponseClass() {
        return EmptyResponse.class;
    }
}
