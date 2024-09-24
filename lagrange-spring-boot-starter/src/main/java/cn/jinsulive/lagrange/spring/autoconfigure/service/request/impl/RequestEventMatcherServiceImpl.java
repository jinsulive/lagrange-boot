package cn.jinsulive.lagrange.spring.autoconfigure.service.request.impl;

import cn.jinsulive.lagrange.core.annotation.request.RequestListenerInfo;
import cn.jinsulive.lagrange.core.constant.request.RequestSubType;
import cn.jinsulive.lagrange.core.constant.request.RequestType;
import cn.jinsulive.lagrange.core.event.request.RequestEvent;
import cn.jinsulive.lagrange.spring.autoconfigure.service.request.RequestEventMatcherService;

/**
 * @author lxy
 * @since 2024年09月08日 03:47:24
 */
public class RequestEventMatcherServiceImpl implements RequestEventMatcherService {

    @Override
    public boolean match(RequestEvent requestEvent, RequestListenerInfo requestListenerInfo) {
        RequestType requestType = requestListenerInfo.getRequestType();
        RequestSubType subType = requestListenerInfo.getSubType();
        return (requestType == RequestType.NULL || requestType == requestEvent.getRequestType()) &&
                (subType == RequestSubType.NULL || subType == requestEvent.getSubType());
    }

}
