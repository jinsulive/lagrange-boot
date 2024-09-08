package com.jinsulive.lagrange.core.annotation.request;

import com.jinsulive.lagrange.core.annotation.Listener;
import com.jinsulive.lagrange.core.constant.request.RequestSubType;
import com.jinsulive.lagrange.core.constant.request.RequestType;

import java.lang.annotation.*;

/**
 * @author lxy
 * @since 2024年09月08日 03:17:03
 */
@Listener(RequestListener.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface RequestListener {

    /**
     * 匹配器
     */
    Match match() default @Match();

    @interface Match {
        /**
         * 请求事件类型
         */
        RequestType requestType() default RequestType.NULL;

        /**
         * 请求事件-请求子类型
         */
        RequestSubType subType() default RequestSubType.NULL;
    }


}
