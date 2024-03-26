package com.jinsulive.lagrange.core.entity.message.data;

/**
 * 位置
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E4%BD%8D%E7%BD%AE" />
 * @since 2024年03月06日 23:34:23
 */
public class Location {

    private String lat;

    private String lon;

    private String title;

    private String content;

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
