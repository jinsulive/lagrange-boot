package com.jinsulive.lagrange.sdk.response.group.data;

import cn.hutool.json.JSONUtil;

import java.util.List;

/**
 * @author lxy
 * @since 2024年09月11日 15:36:44
 */
public class GroupHonorInfoData {

    /**
     * 群号
     */
    private Long groupId;

    /**
     * 当前龙王，仅 type 为 talkative 或 all 时有数据
     */
    private Detail currentTalkative;

    /**
     * 历史龙王，仅 type 为 talkative 或 all 时有数据
     */
    private List<Detail> talkativeList;

    /**
     * 群聊之火，仅 type 为 performer 或 all 时有数据
     */
    private List<Detail> performerList;

    /**
     * 群聊炽焰，仅 type 为 legend 或 all 时有数据
     */
    private List<Detail> legendList;

    /**
     * 冒尖小春笋，仅 type 为 strong_newbie 或 all 时有数据
     */
    private List<Detail> strongNewbieList;

    /**
     * 快乐之源，仅 type 为 emotion 或 all 时有数据
     */
    private List<Detail> emotionList;

    public GroupHonorInfoData() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Detail getCurrentTalkative() {
        return currentTalkative;
    }

    public void setCurrentTalkative(Detail currentTalkative) {
        this.currentTalkative = currentTalkative;
    }

    public List<Detail> getTalkativeList() {
        return talkativeList;
    }

    public void setTalkativeList(List<Detail> talkativeList) {
        this.talkativeList = talkativeList;
    }

    public List<Detail> getPerformerList() {
        return performerList;
    }

    public void setPerformerList(List<Detail> performerList) {
        this.performerList = performerList;
    }

    public List<Detail> getLegendList() {
        return legendList;
    }

    public void setLegendList(List<Detail> legendList) {
        this.legendList = legendList;
    }

    public List<Detail> getStrongNewbieList() {
        return strongNewbieList;
    }

    public void setStrongNewbieList(List<Detail> strongNewbieList) {
        this.strongNewbieList = strongNewbieList;
    }

    public List<Detail> getEmotionList() {
        return emotionList;
    }

    public void setEmotionList(List<Detail> emotionList) {
        this.emotionList = emotionList;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public static class Detail {
        /**
         * QQ 号
         */
        private Long userId;
        /**
         * 昵称
         */
        private String nickname;
        /**
         * 头像 URL
         */
        private String avatar;
        /**
         * 持续天数
         * 仅currentTalkative存在
         */
        private Integer dayCount;
        /**
         * 荣誉描述
         */
        private String description;

        public Detail() {
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public Integer getDayCount() {
            return dayCount;
        }

        public void setDayCount(Integer dayCount) {
            this.dayCount = dayCount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return JSONUtil.toJsonStr(this);
        }
    }


}

