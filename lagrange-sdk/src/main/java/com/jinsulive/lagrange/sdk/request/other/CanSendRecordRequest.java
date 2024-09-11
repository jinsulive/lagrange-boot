package com.jinsulive.lagrange.sdk.request.other;

import com.jinsulive.lagrange.sdk.request.AbstractRequest;
import com.jinsulive.lagrange.sdk.response.other.CanSendResponse;

/**
 * 检查是否可以发送语音
 *
 * @author lxy
 * @since 2024年09月11日 16:09:20
 */
public class CanSendRecordRequest extends AbstractRequest<CanSendResponse> {

    @Override
    public String getServiceUrl() {
        return "can_send_record";
    }

    @Override
    public String getJsonParamString() {
        return "{}";
    }

    @Override
    public Class<CanSendResponse> getResponseClass() {
        return CanSendResponse.class;
    }
}