package com.jinsulive.lagrange.core.entity.message.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * xml
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#xml-%E6%B6%88%E6%81%AF" />
 * @since 2024年03月07日 00:16:28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Xml {
    private String data;
}
