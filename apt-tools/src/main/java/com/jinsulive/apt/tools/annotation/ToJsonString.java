package com.jinsulive.apt.tools.annotation;

import java.lang.annotation.*;

/**
 * 序列化为Json字符串
 *
 * @author lxy
 * @since 2024年03月29日 16:16:46
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface ToJsonString {
}
