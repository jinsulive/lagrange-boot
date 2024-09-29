package cn.jinsulive.lagrange.spring.autoconfigure;

import cn.jinsulive.lagrange.spring.autoconfigure.config.LagrangeSdkClientRegistryRunner;
import cn.jinsulive.lagrange.spring.autoconfigure.constant.SendType;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.Nullable;

/**
 * @author lxy
 * @since 2024年03月18日 14:51:55
 */
public class LagrangeBotImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(@Nullable AnnotationMetadata importingClassMetadata) {
        if (importingClassMetadata != null) {
            AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(
                    importingClassMetadata.getAnnotationAttributes(EnableLagrangeBot.class.getName())
            );
            if (annotationAttributes != null) {
                SendType sendType = annotationAttributes.getEnum("sendType");
                if (sendType == SendType.HTTP) {
                    return new String[]{LagrangeSdkClientRegistryRunner.class.getName()};
                }
            }
        }
        return new String[0];
    }
}
