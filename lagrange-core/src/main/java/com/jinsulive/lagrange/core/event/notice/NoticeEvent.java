package com.jinsulive.lagrange.core.event.notice;

import com.jinsulive.lagrange.core.event.BaseEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lxy
 * @since 2024年03月06日 13:42:02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NoticeEvent extends BaseEvent {
    private Integer groupId;
    private Integer userId;
    private Integer messageId;
    private Integer operatorId;
    private String noticeType;
}
