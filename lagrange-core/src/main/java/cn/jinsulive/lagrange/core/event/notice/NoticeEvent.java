package cn.jinsulive.lagrange.core.event.notice;

import cn.jinsulive.lagrange.core.constant.HonorType;
import cn.jinsulive.lagrange.core.constant.notice.NoticeSubType;
import cn.jinsulive.lagrange.core.constant.notice.NoticeType;
import cn.jinsulive.lagrange.core.entity.notice.FileInfo;
import cn.jinsulive.lagrange.core.event.BaseEvent;

/**
 * @author lxy
 * @since 2024年03月06日 13:42:02
 */
public class NoticeEvent extends BaseEvent {
    /**
     * 群号
     */
    private Long groupId;
    /**
     * 发送者QQ号/管理员QQ号/离开者QQ号/加入者QQ号/被禁言QQ号/新添加好友QQ号/好友QQ号/红包发送者QQ号/成员QQ号
     */
    private Long userId;
    /**
     * 文件信息
     */
    private FileInfo file;
    /**
     * 被撤回的消息ID
     */
    private Integer messageId;
    /**
     * 运气王QQ号/被戳者QQ号
     */
    private Integer targetId;
    /**
     * 操作者QQ号(如果是主动退群，则和 userId 相同)
     */
    private Integer operatorId;
    /**
     * 通知类型
     */
    private NoticeType noticeType;
    /**
     * 子类型
     */
    private NoticeSubType subType;

    /**
     * 荣誉类型
     */
    private HonorType honorType;

    /**
     * 禁言时长，单位秒
     */
    private Integer duration;

    public NoticeEvent() {
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

    public FileInfo getFile() {
        return file;
    }

    public void setFile(FileInfo file) {
        this.file = file;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public NoticeType getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(NoticeType noticeType) {
        this.noticeType = noticeType;
    }

    public NoticeSubType getSubType() {
        return subType;
    }

    public void setSubType(NoticeSubType subType) {
        this.subType = subType;
    }

    public HonorType getHonorType() {
        return honorType;
    }

    public void setHonorType(HonorType honorType) {
        this.honorType = honorType;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
