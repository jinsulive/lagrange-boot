package com.jinsulive.lagrange.sdk.response.message;

import com.jinsulive.lagrange.sdk.response.AbstractResponse;
import com.jinsulive.lagrange.sdk.response.message.data.MessageHandleData;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 发送/撤销
 *
 * @author lxy
 * @since 2024年03月15日 14:20:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MessageHandleResponse extends AbstractResponse {

    private MessageHandleData data;

}
