package com.jinsulive.lagrange.core.annotation.request;

import com.jinsulive.lagrange.core.annotation.ListenerInfo;
import com.jinsulive.lagrange.core.constant.request.RequestSubType;
import com.jinsulive.lagrange.core.constant.request.RequestType;

import java.lang.reflect.Method;

/**
 * @author lxy
 * @since 2024年09月08日 02:53:42
 */
public class RequestListenerInfo extends ListenerInfo {

    private String name;

    private RequestType requestType;

    private RequestSubType subType;

    private Method method;

    public static Builder builder() {
        return new Builder();
    }

    private RequestListenerInfo(Builder builder) {
        name = builder.name;
        requestType = builder.requestType;
        subType = builder.subType;
        method = builder.method;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
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
