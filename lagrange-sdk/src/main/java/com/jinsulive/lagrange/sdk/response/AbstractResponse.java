package com.jinsulive.lagrange.sdk.response;

/**
 * @author lxy
 * @since 2024年03月15日 14:07:25
 */
@SuppressWarnings("SpellCheckingInspection")
public abstract class AbstractResponse {

    private String status;
    private Integer retcode;
    private Object echo;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRetcode() {
        return retcode;
    }

    public void setRetcode(Integer retcode) {
        this.retcode = retcode;
    }

    public Object getEcho() {
        return echo;
    }

    public void setEcho(Object echo) {
        this.echo = echo;
    }
}
