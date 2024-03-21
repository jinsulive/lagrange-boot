package com.jinsulive.lagrange.sdk.response.info;

import com.jinsulive.lagrange.sdk.response.AbstractResponse;
import com.jinsulive.lagrange.sdk.response.info.data.StrangerInfoData;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lxy
 * @since 2024年03月21日 15:20:45
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class StrangerInfoResponse extends AbstractResponse {

    private StrangerInfoData data;

}
