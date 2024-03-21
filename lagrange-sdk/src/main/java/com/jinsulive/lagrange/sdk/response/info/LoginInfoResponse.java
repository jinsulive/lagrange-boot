package com.jinsulive.lagrange.sdk.response.info;

import com.jinsulive.lagrange.sdk.response.AbstractResponse;
import com.jinsulive.lagrange.sdk.response.info.data.LoginInfoData;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lxy
 * @since 2024年03月21日 15:11:27
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LoginInfoResponse extends AbstractResponse {

    private LoginInfoData data;

}
