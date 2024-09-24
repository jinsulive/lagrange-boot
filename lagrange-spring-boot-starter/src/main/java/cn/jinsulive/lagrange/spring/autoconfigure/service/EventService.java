package cn.jinsulive.lagrange.spring.autoconfigure.service;

import cn.jinsulive.lagrange.core.constant.PostType;
import cn.jinsulive.lagrange.core.event.BaseEvent;

/**
 * @author lxy
 * @since 2024年03月06日 16:31:00
 */
public interface EventService {

    PostType postType();

    void handler(BaseEvent event);

}
