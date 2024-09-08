package com.jinsulive.lagrange.spring.autoconfigure.service.request;

import com.jinsulive.lagrange.core.annotation.request.RequestListenerInfo;
import com.jinsulive.lagrange.core.event.request.RequestEvent;

/**
 * 请求事件匹配器
 *
 * @author lxy
 * @since 2024年09月08日 03:47:07
 */
public interface RequestEventMatcherService {

    /**
     * 请求匹配
     *
     * @param requestEvent        请求事件
     * @param requestListenerInfo 请求监听器信息
     */
    boolean match(RequestEvent requestEvent, RequestListenerInfo requestListenerInfo);

}
