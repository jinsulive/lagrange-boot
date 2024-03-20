package com.jinsulive.lagrange.spring.autoconfigure.handler;

import com.jinsulive.lagrange.core.constant.PostType;
import com.jinsulive.lagrange.core.event.BaseEvent;
import com.jinsulive.lagrange.spring.autoconfigure.service.EventService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lxy
 * @since 2024年03月06日 16:31:18
 */
@Slf4j
public class EventServiceHandler {

    private static final Map<PostType, EventService> EVENT_SERVICE = new ConcurrentHashMap<>();

    public EventServiceHandler(List<EventService> eventService) {
        for (EventService service : eventService) {
            if (Objects.nonNull(service.postType())) {
                EVENT_SERVICE.put(service.postType(), service);
            }
        }
    }

    public void handle(BaseEvent event) {
        EventService eventService = EVENT_SERVICE.get(event.getPostType());
        if (Objects.isNull(eventService)) {
            log.warn("未找到对应的事件处理器 postType: {}", event.getPostType());
            return;
        }
        eventService.handler(event);
    }

}
