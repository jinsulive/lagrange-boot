package com.jinsulive.lagrange.core.event;

import com.jinsulive.lagrange.core.constant.PostType;

/**
 * @author lxy
 * @since 2024年03月06日 11:39:49
 */
public class BaseEvent {

    private Long time;

    private Long selfId;

    private PostType postType;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getSelfId() {
        return selfId;
    }

    public void setSelfId(Long selfId) {
        this.selfId = selfId;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }
}
