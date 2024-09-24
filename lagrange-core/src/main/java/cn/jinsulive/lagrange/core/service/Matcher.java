package cn.jinsulive.lagrange.core.service;

/**
 * 一个匹配器，提供一个 T 作为被匹配的目标，R 为匹配原则/规则， 并得到一个匹配结果。
 *
 * @author lxy
 * @since 2024年03月07日 14:14:06
 */
public interface Matcher<T, R> {

    /**
     * 匹配
     *
     * @param target 被匹配的目标
     * @param rule   匹配规则
     * @return 匹配结果
     */
    boolean match(T target, R rule);

}
