package cn.jinsulive.lagrange.core.annotation;

import java.lang.reflect.Method;

/**
 * @author lxy
 * @since 2024年09月08日 03:07:04
 */
public class ListenerInfo {
    private String name;

    private Method method;

    public ListenerInfo(String name, Method method) {
        this.name = name;
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
