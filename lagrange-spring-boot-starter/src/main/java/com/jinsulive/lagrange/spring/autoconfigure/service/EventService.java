package com.jinsulive.lagrange.spring.autoconfigure.service;

import com.jinsulive.lagrange.core.constant.PostType;
import com.jinsulive.lagrange.core.event.BaseEvent;

/**
 * @author lxy
 * @since 2024年03月06日 16:31:00
 */
public interface EventService {

    PostType postType();

    void handler(BaseEvent event);

}
