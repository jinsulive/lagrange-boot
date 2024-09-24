package cn.jinsulive.lagrange.spring.autoconfigure.entity;

import cn.jinsulive.lagrange.core.annotation.ListenerInfo;

import java.util.List;

/**
 * 监听函数上下文
 *
 * @author lxy
 * @since 2024年03月11日 15:27:15
 */
public final class MethodListenerContext {

    private List<ListenerInfo> listenerInfos;

    public MethodListenerContext() {
    }

    private MethodListenerContext(Builder builder) {
        listenerInfos = builder.listenerInfos;
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<ListenerInfo> getListenerInfos() {
        return listenerInfos;
    }

    public void setListenerInfos(List<ListenerInfo> listenerInfos) {
        this.listenerInfos = listenerInfos;
    }

    public static final class Builder {
        private List<ListenerInfo> listenerInfos;

        private Builder() {
        }

        public Builder listenerInfos(List<ListenerInfo> listenerInfos) {
            this.listenerInfos = listenerInfos;
            return this;
        }

        public MethodListenerContext build() {
            return new MethodListenerContext(this);
        }
    }
}
