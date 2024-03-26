package com.jinsulive.lagrange.spring.autoconfigure.service.request;

import com.jinsulive.lagrange.core.constant.PostType;
import com.jinsulive.lagrange.core.event.BaseEvent;
import com.jinsulive.lagrange.core.event.request.RequestEvent;
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
public class RequestEventService implements EventService {

    private static final Logger log = LoggerFactory.getLogger(RequestEventService.class);

    @Resource
    private LagrangeConfig lagrangeConfig;

    @Override
    public PostType postType() {
        return PostType.REQUEST;
    }

    @Override
    public void handler(BaseEvent event) {
        RequestEvent requestEvent = (RequestEvent) event;
        LogUtil.debug(lagrangeConfig.isOpenDebugLog(), "[RequestEvent] 收到request消息: {}", requestEvent);
    }
}
