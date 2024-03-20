package com.jinsulive.lagrange.core.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lxy
 * @since 2024年03月06日 17:28:32
 */
@Slf4j
public class LogUtil {

    public static void debug(boolean condition, String message, Object... args) {
        if (condition) {
            log.debug(message, args);
        }
    }

    public static void info(boolean condition, String message, Object... args) {
        if (condition) {
            log.info(message, args);
        }
    }

    public static void warn(boolean condition, String message, Object... args) {
        if (condition) {
            log.warn(message, args);
        }
    }

    public static void error(boolean condition, String message, Object... args) {
        if (condition) {
            log.error(message, args);
        }
    }

}
