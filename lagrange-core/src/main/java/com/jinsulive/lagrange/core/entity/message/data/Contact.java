package com.jinsulive.lagrange.core.entity.message.data;

import com.jinsulive.lagrange.core.constant.message.data.ContactType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 推荐好友/群
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E9%93%BE%E6%8E%A5%E5%88%86%E4%BA%AB" />
 * @since 2024年03月06日 23:30:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private ContactType type;
    private String qq;
}
