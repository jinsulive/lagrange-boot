package com.jinsulive.lagrange.sdk.request.other;

import cn.hutool.http.Method;
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
    public Method getMethod() {
        return Method.GET;
    }

    @Override
    public String getServiceUrl() {
        return "can_send_record";
    }

    @Override
    public Class<CanSendResponse> getResponseClass() {
        return CanSendResponse.class;
    }
}