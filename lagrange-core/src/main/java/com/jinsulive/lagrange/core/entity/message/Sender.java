package com.jinsulive.lagrange.core.entity.message;

import com.jinsulive.lagrange.core.constant.message.SenderRoleType;
import com.jinsulive.lagrange.core.constant.message.SenderSexType;
import lombok.Data;

/**
 * @author lxy
 * @since 2024年03月06日 14:28:36
 */
@Data
public class Sender {

    private long userId;
    private String nickname;
    private String card;
    private SenderSexType sex;
    private int age;
    private String area;
    private String level;
    private SenderRoleType role;
    private String title;

}
