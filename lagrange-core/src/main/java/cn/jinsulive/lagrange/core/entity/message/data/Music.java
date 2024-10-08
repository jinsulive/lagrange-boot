package cn.jinsulive.lagrange.core.entity.message.data;

import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.core.constant.message.data.MusicType;

/**
 * 音乐分享/音乐自定义分享
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E9%9F%B3%E4%B9%90">音乐</a>
 * @since 2024年03月06日 23:36:31
 */
public class Music {
    /**
     * 音乐类型
     */
    private MusicType type;
    /**
     * 歌曲 ID
     */
    private String id;
    /**
     * 点击后跳转目标 URL
     */
    private String url;
    /**
     * 音乐 URL
     */
    private String audio;
    /**
     * 标题
     */
    private String title;
    /**
     * 发送时可选，内容描述
     */
    private String content;
    /**
     * 发送时可选，图片 URL
     */
    private String image;

    public Music() {
    }

    private Music(Builder builder) {
        type = builder.type;
        id = builder.id;
        url = builder.url;
        audio = builder.audio;
        title = builder.title;
        content = builder.content;
        image = builder.image;
    }

    public static Builder builder() {
        return new Builder();
    }

    public MusicType getType() {
        return type;
    }

    public void setType(MusicType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public static final class Builder {
        private MusicType type;
        private String id;
        private String url;
        private String audio;
        private String title;
        private String content;
        private String image;

        private Builder() {
        }

        public Builder type(MusicType type) {
            this.type = type;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder audio(String audio) {
            this.audio = audio;
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

        public Builder image(String image) {
            this.image = image;
            return this;
        }

        public Music build() {
            return new Music(this);
        }
    }

}
