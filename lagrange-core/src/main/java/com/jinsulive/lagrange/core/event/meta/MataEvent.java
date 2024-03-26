package com.jinsulive.lagrange.core.event.meta;

import com.jinsulive.lagrange.core.entity.meta.MataStatus;
import com.jinsulive.lagrange.core.event.BaseEvent;

/**
 * @author lxy
 * @since 2024年03月05日 15:50:31
 */
public class MataEvent extends BaseEvent {

    private int interval;
    private MataStatus status;
    private String metaEventType;

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


