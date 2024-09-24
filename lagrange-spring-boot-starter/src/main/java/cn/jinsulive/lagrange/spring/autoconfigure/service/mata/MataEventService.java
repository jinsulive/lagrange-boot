package cn.jinsulive.lagrange.spring.autoconfigure.service.mata;

import cn.jinsulive.lagrange.core.constant.PostType;
import cn.jinsulive.lagrange.core.event.BaseEvent;
import cn.jinsulive.lagrange.core.event.meta.MataEvent;
import cn.jinsulive.lagrange.core.util.LogUtil;
import cn.jinsulive.lagrange.spring.autoconfigure.config.LagrangeConfig;
import cn.jinsulive.lagrange.spring.autoconfigure.service.EventService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @author lxy
 * @since 2024年03月06日 17:06:07
 */
public class MataEventService implements EventService {

    private static final Logger log = LoggerFactory.getLogger(MataEventService.class);

    @Resource
    private LagrangeConfig lagrangeConfig;

    @Override
    public PostType postType() {
        return PostType.META_EVENT;
    }

    @Override
    public void handler(BaseEvent event) {
        MataEvent mataEvent = (MataEvent) event;
        if (Objects.equals("lifecycle", mataEvent.getMetaEventType())) {
            log.info("[MataEvent] websocket连接成功");
        }
        LogUtil.debug(lagrangeConfig.isOpenMataEventLog(), "[MataEvent] 收到mata_event消息: {}", mataEvent);
    }
}
