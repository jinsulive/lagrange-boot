package com.jinsulive.lagrange.core.entity.message.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 合并转发
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E5%90%88%E5%B9%B6%E8%BD%AC%E5%8F%91-" />
 * @since 2024年03月07日 00:10:53
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Forward {
    private String id;
}
