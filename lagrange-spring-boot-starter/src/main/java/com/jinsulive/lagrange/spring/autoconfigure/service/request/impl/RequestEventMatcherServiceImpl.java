package com.jinsulive.lagrange.spring.autoconfigure.service.request.impl;

import com.jinsulive.lagrange.core.annotation.request.RequestListenerInfo;
import com.jinsulive.lagrange.core.constant.request.RequestSubType;
import com.jinsulive.lagrange.core.constant.request.RequestType;
import com.jinsulive.lagrange.core.event.request.RequestEvent;
import com.jinsulive.lagrange.spring.autoconfigure.service.request.RequestEventMatcherService;
import org.springframework.stereotype.Service;

/**
 * @author lxy
 * @since 2024年09月08日 03:47:24
 */
@Service
public class RequestEventMatcherServiceImpl implements RequestEventMatcherService {

    @Override
    public boolean match(RequestEvent requestEvent, RequestListenerInfo requestListenerInfo) {
        RequestType requestType = requestListenerInfo.getRequestType();
        RequestSubType subType = requestListenerInfo.getSubType();
        return (requestType == RequestType.NULL || requestType == requestEvent.getRequestType()) &&
                (subType == RequestSubType.NULL || subType == requestEvent.getSubType());
    }

}
