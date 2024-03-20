package com.jinsulive.lagrange.core.entity.message.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 图片
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E5%9B%BE%E7%89%87"/>
 * @since 2024年03月06日 22:58:08
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    private String file;
    private String url;
    private String type;
    private Integer cache;
    private Integer proxy;
    private Integer timeout;

}
