package com.jinsulive.lagrange.core.entity.message.data;

import com.jinsulive.lagrange.core.entity.message.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 合并转发/合并转发节点
 *
 * @author lxy
 * @see <a href="https://github.com/botuniverse/onebot-11/blob/master/message/segment.md#%E5%90%88%E5%B9%B6%E8%BD%AC%E5%8F%91%E8%8A%82%E7%82%B9-" />
 * @since 2024年03月07日 00:13:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Node {

    private String id;
    private String userId;
    private String nickname;
    private List<Message> content;

}
