package com.jinsulive.lagrange.core.annotation.message;

import com.jinsulive.lagrange.core.constant.core.MatchType;
import lombok.Builder;
import lombok.Getter;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author lxy
 * @since 2024年03月08日 14:46:28
 */
@Getter
@Builder
public class MessageListenerInfo {

    private String name;

    private boolean contentTrim;

    private MatchType matchType;

    private String matchValue;

    private List<String> bots;

    private List<String> groups;

    private List<String> authors;

    private boolean atBot;

    private Method method;

}
