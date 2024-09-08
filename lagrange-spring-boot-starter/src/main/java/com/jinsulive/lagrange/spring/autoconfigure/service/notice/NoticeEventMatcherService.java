package com.jinsulive.lagrange.spring.autoconfigure.service.notice;

import com.jinsulive.lagrange.core.annotation.notice.NoticeListenerInfo;
import com.jinsulive.lagrange.core.annotation.request.RequestListenerInfo;
import com.jinsulive.lagrange.core.event.notice.NoticeEvent;

/**
 * 通知事件匹配器
 *
 * @author lxy
 * @since 2024年09月08日 03:47:07
 */
public interface NoticeEventMatcherService {

    /**
     * 通知匹配
     *
     * @param noticeEvent         通知事件
     * @param noticeListenerInfo  通知监听器信息
     */
    boolean match(NoticeEvent noticeEvent, NoticeListenerInfo noticeListenerInfo);

}
