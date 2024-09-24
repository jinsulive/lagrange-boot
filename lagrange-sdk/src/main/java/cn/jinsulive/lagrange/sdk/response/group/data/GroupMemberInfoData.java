package cn.jinsulive.lagrange.sdk.response.group.data;

import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.core.constant.SexType;

/**
 * @author lxy
 * @since 2024年09月11日 14:14:30
 */
public class GroupMemberInfoData {

    /**
     * 群号
     */
    private Long groupId;
    /**
     * QQ 号
     */
    private Long userId;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 群名片／备注
     */
    private String card;
    /**
     * 性别
     */
    private SexType sex;
    /**
     * 年龄
     */
    private Long age;
    /**
     * 地区
     */
    private String area;
    /**
     * 加群时间戳
     */
    private Long joinTime;
    /**
     * 最后发言时间戳
     */
    private Long lastSentTime;
    /**
     * 成员等级
     */
    private String level;
    /**
     * 角色
     */
    private String role;
    /**
     * 是否不良记录成员
     */
    private Boolean unfriendly;
    /**
     * 专属头衔
     */
    private String title;
    /**
     * 专属头衔过期时间戳
     */
    private Long titleExpireTime;
    /**
     * 是否允许修改群名片
     */
    private Boolean cardChangeable;

    public GroupMemberInfoData() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public SexType getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Long getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Long joinTime) {
        this.joinTime = joinTime;
    }

    public Long getLastSentTime() {
        return lastSentTime;
    }

    public void setLastSentTime(Long lastSentTime) {
        this.lastSentTime = lastSentTime;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getUnfriendly() {
        return unfriendly;
    }

    public void setUnfriendly(Boolean unfriendly) {
        this.unfriendly = unfriendly;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTitleExpireTime() {
        return titleExpireTime;
    }

    public void setTitleExpireTime(Long titleExpireTime) {
        this.titleExpireTime = titleExpireTime;
    }

    public Boolean getCardChangeable() {
        return cardChangeable;
    }

    public void setCardChangeable(Boolean cardChangeable) {
        this.cardChangeable = cardChangeable;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

}
