package com.jinsulive.lagrange.spring.autoconfigure.service.notice;

import com.jinsulive.lagrange.core.constant.PostType;
import com.jinsulive.lagrange.core.event.BaseEvent;
import com.jinsulive.lagrange.core.event.notice.NoticeEvent;
import com.jinsulive.lagrange.core.util.LogUtil;
import com.jinsulive.lagrange.spring.autoconfigure.config.LagrangeConfig;
import com.jinsulive.lagrange.spring.autoconfigure.service.EventService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lxy
 * @since 2024年03月06日 16:42:07
 */
public class NoticeEventService implements EventService {

    private static final Logger log = LoggerFactory.getLogger(NoticeEventService.class);

    @Resource
    private LagrangeConfig lagrangeConfig;

    @Override
    public PostType postType() {
        return PostType.NOTICE;
    }

    @Override
    public void handler(BaseEvent event) {
        NoticeEvent noticeEvent = (NoticeEvent) event;
        LogUtil.debug(lagrangeConfig.isOpenDebugLog(), "[NoticeEvent] 收到notice消息: {}", noticeEvent);
    }
}
