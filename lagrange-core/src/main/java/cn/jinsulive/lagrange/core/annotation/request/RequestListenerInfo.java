package cn.jinsulive.lagrange.core.annotation.request;

import cn.jinsulive.lagrange.core.annotation.ListenerInfo;
import cn.jinsulive.lagrange.core.constant.request.RequestSubType;
import cn.jinsulive.lagrange.core.constant.request.RequestType;

import java.lang.reflect.Method;

/**
 * @author lxy
 * @since 2024年09月08日 02:53:42
 */
public class RequestListenerInfo extends ListenerInfo {

    private RequestType requestType;

    private RequestSubType subType;

    private RequestListenerInfo(Builder builder) {
        super(builder.name, builder.method);
        requestType = builder.requestType;
        subType = builder.subType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public RequestSubType getSubType() {
        return subType;
    }

    public void setSubType(RequestSubType subType) {
        this.subType = subType;
    }

    public static class Builder {
        private String name;
        private RequestType requestType;
        private RequestSubType subType;

        private Method method;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder requestType(RequestType requestType) {
            this.requestType = requestType;
            return this;
        }

        public Builder subType(RequestSubType subType) {
            this.subType = subType;
            return this;
        }

        public Builder method(Method method) {
            this.method = method;
            return this;
        }

        public RequestListenerInfo build() {
            return new RequestListenerInfo(this);
        }

    }

}
