package com.jinsulive.lagrange.core.entity.message.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 回复
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E5%9B%9E%E5%A4%8D" />
 * @since 2024年03月07日 00:08:01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
    private String id;
}
