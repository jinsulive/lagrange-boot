package com.jinsulive.lagrange.core.event.meta;

import com.jinsulive.lagrange.core.entity.meta.MataStatus;
import com.jinsulive.lagrange.core.event.BaseEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lxy
 * @since 2024年03月05日 15:50:31
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MataEvent extends BaseEvent {

    private int interval;
    private MataStatus status;
    private String metaEventType;

}


