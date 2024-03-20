package com.jinsulive.lagrange.core.entity.message.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * markdown
 *
 * @author lxy
 * @since 2024年03月07日 00:08:01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Markdown {
    private String content;
}
