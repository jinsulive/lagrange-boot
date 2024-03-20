package com.jinsulive.lagrange.core.entity.message.data;

import com.jinsulive.lagrange.core.constant.message.data.MusicType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 音乐分享/音乐自定义分享
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E9%9F%B3%E4%B9%90" />
 * @since 2024年03月06日 23:36:31
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Music {

    private MusicType type;
    private String id;
    private String url;
    private String audio;
    private String title;
    private String content;
    private String image;

}
