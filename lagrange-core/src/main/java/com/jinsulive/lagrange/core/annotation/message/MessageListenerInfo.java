package com.jinsulive.lagrange.core.annotation.message;

import com.jinsulive.lagrange.core.annotation.ListenerInfo;
import com.jinsulive.lagrange.core.constant.core.MatchType;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author lxy
 * @since 2024年03月08日 14:46:28
 */
public class MessageListenerInfo extends ListenerInfo {

    private boolean contentTrim;

    private MatchType matchType;

    private String matchValue;

    private List<String> bots;

    private List<String> groups;

    private List<String> authors;

    private boolean atBot;

    public MessageListenerInfo(Builder builder) {
        super(builder.name, builder.method);
        contentTrim = builder.contentTrim;
        matchType = builder.matchType;
        matchValue = builder.matchValue;
        bots = builder.bots;
        groups = builder.groups;
        authors = builder.authors;
        atBot = builder.atBot;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean isContentTrim() {
        return contentTrim;
    }

    public void setContentTrim(boolean contentTrim) {
        this.contentTrim = contentTrim;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    public String getMatchValue() {
        return matchValue;
    }

    public void setMatchValue(String matchValue) {
        this.matchValue = matchValue;
    }

    public List<String> getBots() {
        return bots;
    }

    public void setBots(List<String> bots) {
        this.bots = bots;
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public boolean isAtBot() {
        return atBot;
    }

    public void setAtBot(boolean atBot) {
        this.atBot = atBot;
    }

    public static final class Builder {
        private String name;
        private boolean contentTrim;
        private MatchType matchType;
        private String matchValue;
        private List<String> bots;
        private List<String> groups;
        private List<String> authors;
        private boolean atBot;
        private Method method;

        public Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder contentTrim(boolean contentTrim) {
            this.contentTrim = contentTrim;
            return this;
        }

        public Builder matchType(MatchType matchType) {
            this.matchType = matchType;
            return this;
        }

        public Builder matchValue(String matchValue) {
            this.matchValue = matchValue;
            return this;
        }

        public Builder bots(List<String> bots) {
            this.bots = bots;
            return this;
        }

        public Builder groups(List<String> groups) {
            this.groups = groups;
            return this;
        }

        public Builder authors(List<String> authors) {
            this.authors = authors;
            return this;
        }

        public Builder atBot(boolean atBot) {
            this.atBot = atBot;
            return this;
        }

        public Builder method(Method method) {
            this.method = method;
            return this;
        }

        public MessageListenerInfo build() {
            return new MessageListenerInfo(this);
        }
    }

}
