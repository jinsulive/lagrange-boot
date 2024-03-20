package com.jinsulive.lagrange.core.entity.message.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * At某人
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E6%9F%90%E4%BA%BA" />
 * @since 2024年03月06日 23:22:23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class At {
    private String qq;
}
