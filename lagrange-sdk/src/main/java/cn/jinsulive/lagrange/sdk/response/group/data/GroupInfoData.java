package cn.jinsulive.lagrange.sdk.response.group.data;

import cn.hutool.json.JSONUtil;

/**
 * 群信息
 *
 * @author lxy
 * @since 2024年09月11日 15:15:02
 */
public class GroupInfoData {

    /**
     * 群号
     */
    private Long groupId;

    /**
     * 群名称
     */
    private String groupName;

    /**
     * 成员数
     */
    private Integer memberCount;

    /**
     * 最大成员数（群容量）
     */
    private Integer maxMemberCount;

    public GroupInfoData() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    public Integer getMaxMemberCount() {
        return maxMemberCount;
    }

    public void setMaxMemberCount(Integer maxMemberCount) {
        this.maxMemberCount = maxMemberCount;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
