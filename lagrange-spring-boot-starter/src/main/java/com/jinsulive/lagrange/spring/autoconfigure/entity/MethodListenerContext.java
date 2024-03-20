package com.jinsulive.lagrange.spring.autoconfigure.entity;

import com.jinsulive.lagrange.core.annotation.message.MessageListenerInfo;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * 监听函数上下文
 *
 * @author lxy
 * @since 2024年03月11日 15:27:15
 */
@Getter
@Builder
public final class MethodListenerContext {

    private List<MessageListenerInfo> messageListenerInfos;

}
