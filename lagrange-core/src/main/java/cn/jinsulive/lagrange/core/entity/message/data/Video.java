package cn.jinsulive.lagrange.core.entity.message.data;

import cn.hutool.json.JSONUtil;

/**
 * 短视频
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E7%9F%AD%E8%A7%86%E9%A2%91" >短视频</a>
 * @since 2024年03月06日 23:19:51
 */
public class Video {
    /**
     * 视频文件名
     */
    private String file;
    /**
     * 视频 URL
     */
    private String url;
    /**
     * 只在通过网络 URL 发送时有效，表示是否使用已缓存的文件，默认 1
     */
    private Integer cache;
    /**
     * 只在通过网络 URL 发送时有效，表示是否通过代理下载文件（需通过环境变量或配置文件配置代理），默认 1
     */
    private Integer proxy;
    /**
     * 只在通过网络 URL 发送时有效，单位秒，表示下载网络文件的超时时间 ，默认不超时
     */
    private Integer timeout;

    public Video() {
    }

    private Video(Builder builder) {
        file = builder.file;
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

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public static final class Builder {
        private String file;
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

        public Video build() {
            return new Video(this);
        }
    }

}
