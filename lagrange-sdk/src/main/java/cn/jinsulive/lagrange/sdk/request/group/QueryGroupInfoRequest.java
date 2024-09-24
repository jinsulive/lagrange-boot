package cn.jinsulive.lagrange.sdk.request.group;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.sdk.request.AbstractRequest;
import cn.jinsulive.lagrange.sdk.response.group.GroupInfoResponse;

/**
 * 获取群信息
 *
 * @author lxy
 * @since 2024年09月11日 15:14:18
 */
public class QueryGroupInfoRequest extends AbstractRequest<GroupInfoResponse> {

    /**
     * 群号
     */
    private Long groupId;

    /**
     * 是否不使用缓存
     */
    private Boolean noCache = false;

    public QueryGroupInfoRequest() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Boolean getNoCache() {
        return noCache;
    }

    public void setNoCache(Boolean noCache) {
        this.noCache = noCache;
    }

    @Override
    public String getServiceUrl() {
        return "get_group_info";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .putOpt("group_id", groupId)
                .putOpt("no_cache", noCache);
    }

    @Override
    public Class<GroupInfoResponse> getResponseClass() {
        return GroupInfoResponse.class;
    }
}
