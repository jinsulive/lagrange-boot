package com.jinsulive.lagrange.core.entity.message.data;

/**
 * 语音
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E8%AF%AD%E9%9F%B3" />
 * @since 2024年03月06日 23:16:57
 */
public class Record {

    private String file;
    private Integer magic;
    private String url;
    private Integer cache;
    private Integer proxy;
    private Integer timeout;

    public Record() {
    }

    private Record(Builder builder) {
        file = builder.file;
        magic = builder.magic;
        url = builder.url;
        cache = builder.cache;
        proxy = builder.proxy;
        timeout = builder.timeout;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Integer getMagic() {
        return magic;
    }

    public void setMagic(Integer magic) {
        this.magic = magic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCache() {
        return cache;
    }

    public void setCache(Integer cache) {
        this.cache = cache;
    }

    public Integer getProxy() {
        return proxy;
    }

    public void setProxy(Integer proxy) {
        this.proxy = proxy;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public static final class Builder {
        private String file;
        private Integer magic;
        private String url;
        private Integer cache;
        private Integer proxy;
        private Integer timeout;

        private Builder() {
        }

        public Builder file(String file) {
            this.file = file;
            return this;
        }

        public Builder magic(Integer magic) {
            this.magic = magic;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder cache(Integer cache) {
            this.cache = cache;
            return this;
        }

        public Builder proxy(Integer proxy) {
            this.proxy = proxy;
            return this;
        }

        public Builder timeout(Integer timeout) {
            this.timeout = timeout;
            return this;
        }

        public Record build() {
            return new Record(this);
        }
    }
}
