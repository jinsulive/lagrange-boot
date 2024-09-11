package com.jinsulive.lagrange.spring.autoconfigure.service.notice.impl;

import cn.hutool.core.collection.CollUtil;
import com.jinsulive.lagrange.core.annotation.notice.NoticeListenerInfo;
import com.jinsulive.lagrange.core.constant.HonorType;
import com.jinsulive.lagrange.core.constant.notice.NoticeSubType;
import com.jinsulive.lagrange.core.constant.notice.NoticeType;
import com.jinsulive.lagrange.core.event.notice.NoticeEvent;
import com.jinsulive.lagrange.spring.autoconfigure.service.notice.NoticeEventMatcherService;

import java.util.List;

/**
 * @author lxy
 * @since 2024年09月08日 04:06:55
 */
public class NoticeEventMatcherServiceImpl implements NoticeEventMatcherService {

    @Override
    public boolean match(NoticeEvent noticeEvent, NoticeListenerInfo noticeListenerInfo) {
        NoticeType noticeType = noticeListenerInfo.getNoticeType();
        NoticeSubType subType = noticeListenerInfo.getSubType();
        HonorType honorType = noticeListenerInfo.getHonorType();
        List<String> groups = noticeListenerInfo.getGroups();
        return (noticeType == NoticeType.NULL || noticeType == noticeEvent.getNoticeType()) &&
                (subType == NoticeSubType.NULL || subType == noticeEvent.getSubType()) &&
                (honorType == HonorType.NULL || honorType == noticeEvent.getHonorType()) &&
                (CollUtil.isEmpty(groups) || groups.contains(String.valueOf(noticeEvent.getGroupId())));
    }
}
