package cn.jinsulive.lagrange.core.annotation;

import java.lang.annotation.*;

/**
 * 监听器注解
 *
 * @author lxy
 * @since 2024年03月08日 15:28:45
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE})
public @interface Listener {

    Class<? extends Annotation> value();

}
