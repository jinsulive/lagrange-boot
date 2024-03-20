package com.jinsulive.lagrange.core.entity.message.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短视频
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E7%9F%AD%E8%A7%86%E9%A2%91" />
 * @since 2024年03月06日 23:19:51
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Video {

    private String file;
    private String url;
    private Integer cache;
    private Integer proxy;
    private Integer timeout;

}
