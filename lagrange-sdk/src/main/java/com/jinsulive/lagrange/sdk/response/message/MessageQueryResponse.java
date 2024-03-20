package com.jinsulive.lagrange.sdk.response.message;

import com.jinsulive.lagrange.sdk.response.AbstractResponse;
import com.jinsulive.lagrange.sdk.response.message.data.MessageQueryData;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lxy
 * @since 2024年03月20日 21:55:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MessageQueryResponse extends AbstractResponse {

    private MessageQueryData data;

}
