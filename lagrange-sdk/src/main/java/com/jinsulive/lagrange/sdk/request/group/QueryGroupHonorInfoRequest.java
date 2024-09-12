package com.jinsulive.lagrange.sdk.request.group;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.jinsulive.lagrange.core.constant.HonorType;
import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.group.GroupHonorInfoResponse;

import java.util.Optional;

/**
 * 获取群荣誉信息
 *
 * @author lxy
 * @since 2024年09月11日 15:27:29
 */
public class QueryGroupHonorInfoRequest extends AbstractRequest<GroupHonorInfoResponse> {
    /**
     * 群号
     */
    private Long groupId;

    /**
     * 要获取的群荣誉类型，可传入 talkative performer legend strong_newbie emotion 以分别获取单个类型的群荣誉数据，或传入 all 获取所有数据
     */
    private HonorType type;

    public QueryGroupHonorInfoRequest() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public HonorType getType() {
        return type;
    }

    public void setType(HonorType type) {
        this.type = type;
    }

    @Override
    public String getServiceUrl() {
        return "get_group_honor_info";
    }

    @Override
    public JSONObject getParamJson() {
        return JSONUtil.createObj()
                .set("group_id", groupId)
                .putOpt("type", Optional.ofNullable(type).orElse(HonorType.ALL).getValue());
    }

    @Override
    public Class<GroupHonorInfoResponse> getResponseClass() {
        return GroupHonorInfoResponse.class;
    }
}
