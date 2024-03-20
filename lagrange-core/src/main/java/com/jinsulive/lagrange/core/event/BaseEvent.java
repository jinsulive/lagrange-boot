package com.jinsulive.lagrange.core.event;

import com.jinsulive.lagrange.core.constant.PostType;
import lombok.Data;

/**
 * @author lxy
 * @since 2024年03月06日 11:39:49
 */
@Data
public class BaseEvent {

    private Long time;

    private Long selfId;

    private PostType postType;

}
