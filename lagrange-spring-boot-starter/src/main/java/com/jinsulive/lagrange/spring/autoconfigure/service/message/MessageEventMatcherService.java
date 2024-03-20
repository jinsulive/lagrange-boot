package com.jinsulive.lagrange.spring.autoconfigure.service.message;

import com.jinsulive.lagrange.core.annotation.message.MessageListenerInfo;
import com.jinsulive.lagrange.core.event.message.MessageEvent;

/**
 * 消息事件匹配器
 *
 * @author lxy
 * @since 2024年03月11日 16:51:04
 */
public interface MessageEventMatcherService {

    /**
     * 消息校验
     *
     * @param messageEvent        消息事件
     * @param messageListenerInfo 消息监听器信息
     */
    boolean match(MessageEvent messageEvent, MessageListenerInfo messageListenerInfo);

}
