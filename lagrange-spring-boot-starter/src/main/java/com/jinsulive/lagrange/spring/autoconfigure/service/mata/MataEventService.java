package com.jinsulive.lagrange.spring.autoconfigure.service.mata;

import com.jinsulive.lagrange.core.constant.PostType;
import com.jinsulive.lagrange.core.event.BaseEvent;
import com.jinsulive.lagrange.core.event.meta.MataEvent;
import com.jinsulive.lagrange.core.util.LogUtil;
import com.jinsulive.lagrange.spring.autoconfigure.config.LagrangeConfig;
import com.jinsulive.lagrange.spring.autoconfigure.service.EventService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @author lxy
 * @since 2024年03月06日 17:06:07
 */
@Slf4j
public class MataEventService implements EventService {

    @Resource
    private LagrangeConfig lagrangeConfig;

    @Override
    public PostType postType() {
        return PostType.META_EVENT;
    }

    @Override
    public void handler(BaseEvent event) {
        MataEvent mataEvent = (MataEvent) event;
        if (Objects.equals("lifecycle", mataEvent.getMetaEventType())) {
            log.info("[MataEvent] websocket连接成功");
        }
        LogUtil.debug(lagrangeConfig.isOpenMataEventLog(), "[MataEvent] 收到mata_event消息: {}", mataEvent);
    }
}
