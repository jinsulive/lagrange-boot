package com.jinsulive.lagrange.sdk.response.friend.data;

import cn.hutool.json.JSONUtil;

/**
 * 好友信息
 *
 * @author lxy
 * @since 2024年09月11日 15:11:36
 */
public class FriendInfoData {

    /**
     * QQ号
     */
    private Long userId;

    /**
     * qq身份证ID
     */
    private String qId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 备注
     */
    private String remark;

    /**
     * 分组
     */
    private Group group;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getQId() {
        return qId;
    }

    public void setQId(String qId) {
        this.qId = qId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public static class Group {

        /**
         * 分组ID
         */
        private Long groupId;
        /**
         * 分组名称
         */
        private String groupName;

        public Group() {
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

        @Override
        public String toString() {
            return JSONUtil.toJsonStr(this);
        }

    }

}
