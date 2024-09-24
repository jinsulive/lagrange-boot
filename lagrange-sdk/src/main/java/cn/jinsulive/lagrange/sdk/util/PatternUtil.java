package cn.jinsulive.lagrange.sdk.util;

import java.util.Objects;

/**
 * @author lxy
 * @since 2024年09月19日 16:09:15
 */
public class PatternUtil {

    private static final String URL = "(https?:)?(//)?(([0-9a-z.]+\\.[a-z]+)|(([0-9]{1,3}\\.){3}[0-9]{1,3}))(:[0-9]+)?(/[0-9a-z%/.\\-_]*)?(\\?[0-9a-z=&%_\\-]*)?(#[0-9a-z=&%_\\-]*)?";

    public static boolean isUrl(String url) {
        if (Objects.isNull(url)) {
            return false;
        }
        return url.matches(URL);
    }

}
