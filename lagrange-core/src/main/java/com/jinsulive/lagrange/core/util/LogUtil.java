package com.jinsulive.lagrange.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lxy
 * @since 2024年03月06日 17:28:32
 */
public class LogUtil {

    private static final Logger log = LoggerFactory.getLogger(LogUtil.class);

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
