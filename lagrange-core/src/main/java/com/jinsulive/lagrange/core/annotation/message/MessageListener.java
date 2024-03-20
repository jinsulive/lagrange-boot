package com.jinsulive.lagrange.core.annotation.message;

import com.jinsulive.lagrange.core.annotation.Listener;
import com.jinsulive.lagrange.core.constant.core.MatchType;

import java.lang.annotation.*;

/**
 * 监听器注解
 *
 * @author lxy
 * @since 2024年03月07日 11:16:18
 */
@Listener(MessageListener.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MessageListener {

    /**
     * 是否清除前后空格
     */
    boolean contentTrim() default false;

    /**
     * 匹配器
     */
    Match match() default @Match();

    /**
     * 过滤器
     */
    Filter filter() default @Filter();

    @interface Filter {
        /**
         * 对接收事件的botId匹配
         */
        String[] bots() default {};

        /**
         * 对消息发送的群ID匹配
         */
        String[] groups() default {};

        /**
         * 对消息发送者的ID匹配
         */
        String[] authors() default {};

        /**
         * 只有当前消息中存在任意一个 At 消息的时候才会通过匹配
         */
        boolean atBot() default false;
    }

    @interface Match {

        /**
         * 匹配规则值
         */
        String value() default "";

        /**
         * 针对匹配目标所使用的匹配规则。
         * 默认情况下使用 {@link MatchType#REGEX_MATCHES}.
         */
        MatchType matchType() default MatchType.REGEX_MATCHES;

    }

}
