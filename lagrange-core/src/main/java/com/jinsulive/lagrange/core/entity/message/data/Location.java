package com.jinsulive.lagrange.core.entity.message.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 位置
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E4%BD%8D%E7%BD%AE" />
 * @since 2024年03月06日 23:34:23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    private String lat;

    private String lon;

    private String title;

    private String content;

}
