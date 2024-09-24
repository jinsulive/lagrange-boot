package cn.jinsulive.lagrange.spring.autoconfigure.service.notice;

import cn.jinsulive.lagrange.core.annotation.notice.NoticeListenerInfo;
import cn.jinsulive.lagrange.core.event.notice.NoticeEvent;

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
     * @param noticeEvent        通知事件
     * @param noticeListenerInfo 通知监听器信息
     */
    boolean match(NoticeEvent noticeEvent, NoticeListenerInfo noticeListenerInfo);

}
