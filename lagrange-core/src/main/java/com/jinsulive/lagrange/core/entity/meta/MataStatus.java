package com.jinsulive.lagrange.core.entity.meta;

import lombok.Data;

/**
 * @author lxy
 * @since 2024年03月05日 15:51:20
 */
@Data
public class MataStatus {

    private boolean appInitialized;
    private boolean appEnabled;
    private boolean appGood;
    private boolean online;
    private boolean good;

}
