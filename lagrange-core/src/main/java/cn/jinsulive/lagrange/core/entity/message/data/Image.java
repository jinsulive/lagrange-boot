package cn.jinsulive.lagrange.core.entity.message.data;

import cn.hutool.json.JSONUtil;

/**
 * 图片
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E5%9B%BE%E7%89%87">图片</a>
 * @since 2024年03月06日 22:58:08
 */
public class Image {
    /**
     * 图片文件名
     */
    private String file;
    /**
     * 图片 URL
     */
    private String url;
    /**
     * 图片类型，flash 表示闪照，无此参数表示普通图片
     */
    private String type;
    /**
     * 只在通过网络 URL 发送时有效，表示是否使用已缓存的文件，默认 1
     */
    private Integer cache;
    /**
     * 只在通过网络 URL 发送时有效，表示是否通过代理下载文件（需通过环境变量或配置文件配置代理），默认 1
     */
    private Integer proxy;
    /**
     * 只在通过网络 URL 发送时有效，单位秒，表示下载网络文件的超时时间，默认不超时
     */
    private Integer timeout;

    public Image() {
    }

    private Image(Builder builder) {
        file = builder.file;
        url = builder.url;
        type = builder.type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        private String type;
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

        public Builder type(String type) {
            this.type = type;
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

        public Image build() {
            return new Image(this);
        }
    }

}
