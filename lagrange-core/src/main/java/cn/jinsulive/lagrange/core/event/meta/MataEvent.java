package cn.jinsulive.lagrange.core.event.meta;

import cn.jinsulive.lagrange.core.entity.meta.MataStatus;
import cn.jinsulive.lagrange.core.event.BaseEvent;

/**
 * @author lxy
 * @since 2024年03月05日 15:50:31
 */
public class MataEvent extends BaseEvent {

    private int interval;
    private MataStatus status;
    private String metaEventType;

    public MataEvent() {
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public MataStatus getStatus() {
        return status;
    }

    public void setStatus(MataStatus status) {
        this.status = status;
    }

    public String getMetaEventType() {
        return metaEventType;
    }

    public void setMetaEventType(String metaEventType) {
        this.metaEventType = metaEventType;
    }
}


