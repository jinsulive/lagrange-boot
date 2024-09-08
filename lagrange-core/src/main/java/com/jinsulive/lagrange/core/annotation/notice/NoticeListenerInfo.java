package com.jinsulive.lagrange.core.annotation.notice;

import com.jinsulive.lagrange.core.annotation.ListenerInfo;
import com.jinsulive.lagrange.core.constant.notice.HonorType;
import com.jinsulive.lagrange.core.constant.notice.NoticeSubType;
import com.jinsulive.lagrange.core.constant.notice.NoticeType;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author lxy
 * @since 2024年09月08日 02:53:42
 */
public class NoticeListenerInfo extends ListenerInfo {

    private NoticeType noticeType;

    private NoticeSubType subType;

    private HonorType honorType;

    private List<String> groups;

    public NoticeListenerInfo(Builder builder) {
        super(builder.name, builder.method);
        noticeType = builder.noticeType;
        subType = builder.subType;
        honorType = builder.honorType;
        groups = builder.groups;
    }

    public static Builder builder() {
        return new Builder();
    }

    public NoticeType getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(NoticeType noticeType) {
        this.noticeType = noticeType;
    }

    public NoticeSubType getSubType() {
        return subType;
    }

    public void setSubType(NoticeSubType subType) {
        this.subType = subType;
    }

    public HonorType getHonorType() {
        return honorType;
    }

    public void setHonorType(HonorType honorType) {
        this.honorType = honorType;
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public static class Builder {
        private String name;
        private NoticeType noticeType;
        private NoticeSubType subType;
        private HonorType honorType;
        private List<String> groups;

        private Method method;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder noticeType(NoticeType noticeType) {
            this.noticeType = noticeType;
            return this;
        }

        public Builder subType(NoticeSubType subType) {
            this.subType = subType;
            return this;
        }

        public Builder honorType(HonorType honorType) {
            this.honorType = honorType;
            return this;
        }

        public Builder groups(List<String> groups) {
            this.groups = groups;
            return this;
        }

        public Builder method(Method method) {
            this.method = method;
            return this;
        }

        public NoticeListenerInfo build() {
            return new NoticeListenerInfo(this);
        }

    }

}
