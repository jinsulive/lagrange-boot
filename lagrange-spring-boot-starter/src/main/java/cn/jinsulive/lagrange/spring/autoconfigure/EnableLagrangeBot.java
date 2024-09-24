package cn.jinsulive.lagrange.spring.autoconfigure;

import cn.jinsulive.lagrange.spring.autoconfigure.constant.SendType;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author lxy
 * @since 2024年03月18日 14:01:54
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@AutoConfigurationPackage
@Import({
        LagrangeBotAutoConfiguration.class,
        LagrangeBotImportSelector.class
})
public @interface EnableLagrangeBot {

    SendType sendType() default SendType.NONE;

}
