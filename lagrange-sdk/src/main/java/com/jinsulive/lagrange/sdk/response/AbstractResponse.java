package com.jinsulive.lagrange.sdk.response;

import lombok.Data;

/**
 * @author lxy
 * @since 2024年03月15日 14:07:25
 */

@Data
public abstract class AbstractResponse {

    private String status;
    @SuppressWarnings("all")
    private Integer retcode;
    private Object echo;

}
