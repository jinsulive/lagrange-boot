package com.jinsulive.lagrange.core.entity.message.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * QQ表情
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#qq-%E8%A1%A8%E6%83%85" />
 * @since 2024年03月06日 22:52:58
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Face {
    private String id;
}
