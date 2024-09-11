package com.jinsulive.lagrange.core.annotation.notice;

import com.jinsulive.lagrange.core.annotation.Listener;
import com.jinsulive.lagrange.core.constant.HonorType;
import com.jinsulive.lagrange.core.constant.notice.NoticeSubType;
import com.jinsulive.lagrange.core.constant.notice.NoticeType;

import java.lang.annotation.*;

/**
 * 通知事件监听器
 *
 * @author lxy
 * @since 2024年09月08日 02:15:19
 */
@Listener(NoticeListener.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface NoticeListener {

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
         * 对消息发送的群ID匹配
         */
        String[] groups() default {};
    }

    @interface Match {
        /**
         * 通知消息类型
         */
        NoticeType noticeType() default NoticeType.NULL;

        /**
         * 通知消息-提示类型
         */
        NoticeSubType subType() default NoticeSubType.NULL;

        /**
         * 通知消息-荣誉类型
         */
        HonorType honorType() default HonorType.NULL;
    }

}
