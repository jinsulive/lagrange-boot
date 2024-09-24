package cn.jinsulive.lagrange.core.entity.message.data;

import cn.hutool.json.JSONUtil;

/**
 * 位置
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E4%BD%8D%E7%BD%AE">位置</a>
 * @since 2024年03月06日 23:34:23
 */
public class Location {
    /**
     * 纬度
     */
    private String lat;
    /**
     * 经度
     */
    private String lon;
    /**
     * 发送时可选，标题
     */
    private String title;
    /**
     * 发送时可选，内容描述
     */
    private String content;

    public Location() {
    }

    private Location(Builder builder) {
        this.lat = builder.lat;
        this.lon = builder.lon;
        this.title = builder.title;
        this.content = builder.content;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public static final class Builder {
        private String lat;
        private String lon;
        private String title;
        private String content;

        private Builder() {
        }

        public Builder lat(String lat) {
            this.lat = lat;
            return this;
        }

        public Builder lon(String lon) {
            this.lon = lon;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }

}
