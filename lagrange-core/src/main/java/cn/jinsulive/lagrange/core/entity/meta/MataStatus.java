package cn.jinsulive.lagrange.core.entity.meta;

import cn.hutool.json.JSONUtil;

/**
 * @author lxy
 * @since 2024年03月05日 15:51:20
 */
public class MataStatus {

    private boolean appInitialized;
    private boolean appEnabled;
    private boolean appGood;
    private boolean online;
    private boolean good;

    public MataStatus() {
    }

    private MataStatus(Builder builder) {
        this.appInitialized = builder.appInitialized;
        this.appEnabled = builder.appEnabled;
        this.appGood = builder.appGood;
        this.online = builder.online;
        this.good = builder.good;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean isAppInitialized() {
        return appInitialized;
    }

    public void setAppInitialized(boolean appInitialized) {
        this.appInitialized = appInitialized;
    }

    public boolean isAppEnabled() {
        return appEnabled;
    }

    public void setAppEnabled(boolean appEnabled) {
        this.appEnabled = appEnabled;
    }

    public boolean isAppGood() {
        return appGood;
    }

    public void setAppGood(boolean appGood) {
        this.appGood = appGood;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isGood() {
        return good;
    }

    public void setGood(boolean good) {
        this.good = good;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public static final class Builder {
        private boolean appInitialized;
        private boolean appEnabled;
        private boolean appGood;
        private boolean online;
        private boolean good;

        private Builder() {
        }

        public Builder appInitialized(boolean appInitialized) {
            this.appInitialized = appInitialized;
            return this;
        }

        public Builder appEnabled(boolean appEnabled) {
            this.appEnabled = appEnabled;
            return this;
        }

        public Builder appGood(boolean appGood) {
            this.appGood = appGood;
            return this;
        }

        public Builder online(boolean online) {
            this.online = online;
            return this;
        }

        public Builder good(boolean good) {
            this.good = good;
            return this;
        }

        public MataStatus build() {
            return new MataStatus(this);
        }
    }

}
