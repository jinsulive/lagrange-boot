package com.jinsulive.lagrange.core.entity.message.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 语音
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E8%AF%AD%E9%9F%B3" />
 * @since 2024年03月06日 23:16:57
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Record {

    private String file;
    private Integer magic;
    private String url;
    private Integer cache;
    private Integer proxy;
    private Integer timeout;

}
