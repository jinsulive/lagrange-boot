package com.jinsulive.lagrange.core.entity.message.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 纯文本
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E7%BA%AF%E6%96%87%E6%9C%AC" />
 * @since 2024年03月06日 22:51:58
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Text {
    private String text;
}
