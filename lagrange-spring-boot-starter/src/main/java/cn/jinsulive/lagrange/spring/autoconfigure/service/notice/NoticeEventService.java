package cn.jinsulive.lagrange.spring.autoconfigure.service.notice;

import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.core.annotation.ListenerInfo;
import cn.jinsulive.lagrange.core.annotation.notice.NoticeListenerInfo;
import cn.jinsulive.lagrange.core.constant.PostType;
import cn.jinsulive.lagrange.core.event.BaseEvent;
import cn.jinsulive.lagrange.core.event.notice.NoticeEvent;
import cn.jinsulive.lagrange.core.util.LogUtil;
import cn.jinsulive.lagrange.spring.autoconfigure.config.LagrangeConfig;
import cn.jinsulive.lagrange.spring.autoconfigure.entity.MethodListenerContext;
import cn.jinsulive.lagrange.spring.autoconfigure.service.EventService;
import cn.jinsulive.lagrange.spring.autoconfigure.util.SpringUtil;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @author lxy
 * @since 2024年03月06日 16:42:07
 */
public class NoticeEventService implements EventService {

    private static final Logger log = LoggerFactory.getLogger(NoticeEventService.class);

    @Resource(name = "lagrangeExecutorService")
    private ExecutorService executorService;

    @Resource
    private NoticeEventMatcherService noticeEventMatcherService;

    @Resource
    private MethodListenerContext methodListenerContext;

    @Resource
    private LagrangeConfig lagrangeConfig;

    @Override
    public PostType postType() {
        return PostType.NOTICE;
    }

    @Override
    public void handler(BaseEvent event) {
        NoticeEvent noticeEvent = (NoticeEvent) event;
        LogUtil.debug(lagrangeConfig.isOpenDebugLog(), "[NoticeEvent.{}] 收到notice消息: {}", noticeEvent.getSelfId(), noticeEvent);
        executorService.execute(() -> {
            List<ListenerInfo> messageListenerInfos = methodListenerContext.getListenerInfos();
            messageListenerInfos.forEach(listenerInfo -> {
                if (listenerInfo instanceof NoticeListenerInfo noticeListenerInfo) {
                    boolean match = noticeEventMatcherService.match(noticeEvent, noticeListenerInfo);
                    if (match) {
                        this.invoke(noticeEvent, noticeListenerInfo);
                    }
                }
            });
        });
    }

    private void invoke(NoticeEvent noticeEvent, NoticeListenerInfo noticeListenerInfo) {
        Method method = noticeListenerInfo.getMethod();
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length != 1) {
            log.error("[NoticeEvent.invoke.{}] {} should have only one parameter. but found {}.", noticeEvent.getSelfId(), noticeListenerInfo.getName(), parameterTypes.length);
            return;
        }
        Class<?> parameterType = parameterTypes[0];
        Class<?> declaringClass = method.getDeclaringClass();
        try {
            // 从spring中获取实例
            Object instance = SpringUtil.getBean(declaringClass);
            if (parameterType.isAssignableFrom(NoticeEvent.class)) {
                method.invoke(instance, noticeEvent);
            } else if (parameterType.isAssignableFrom(String.class)) {
                method.invoke(instance, JSONUtil.toJsonStr(noticeEvent));
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("[NoticeEvent.invoke.{}] 执行 {} 异常 error: {}", noticeEvent.getSelfId(), noticeListenerInfo.getName(), e.getMessage(), e);
        }
    }
}
