package cn.jinsulive.lagrange.core.constant.core;

import cn.jinsulive.lagrange.core.service.Matcher;

import java.util.regex.Pattern;

/**
 * 匹配类型
 *
 * @author lxy
 * @since 2024年03月07日 11:50:05
 */
public enum MatchType {

    TEXT_EQUALS(String::equals, true),
    TEXT_EQUALS_IGNORE_CASE(String::equalsIgnoreCase, true),
    TEXT_STARTS_WITH(String::startsWith, true),
    TEXT_ENDS_WITH(String::endsWith, true),
    TEXT_CONTAINS(String::contains, true),
    REGEX_MATCHES(String::matches, false),
    REGEX_CONTAINS((target, rule) -> Pattern.compile(rule).matcher(target).find(), false),
    REGEX_ANY((target, rule) -> Pattern.compile("[\\s\\S]*").matcher(target).matches(), false);

    private final Matcher<String, String> matcher;

    /**
     * 代表此匹配模式是否为纯文本匹配而并非通过正则的匹配
     */
    private final boolean plainText;

    MatchType(Matcher<String, String> matcher, boolean plainText) {
        this.matcher = matcher;
        this.plainText = plainText;
    }

    public Matcher<String, String> getMatcher() {
        return matcher;
    }

    public boolean isPlainText() {
        return plainText;
    }

}
