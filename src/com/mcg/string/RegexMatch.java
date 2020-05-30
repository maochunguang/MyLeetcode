package com.mcg.string;

/**
 * @author maocg
 * Date：2018/4/7
 * Description：正则表达式匹配
 * 实现支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个输入字符串（不是部分字符串）。
 * <p>
 * 函数:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * 例子:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
public class RegexMatch {
    /**
     * Description：正则表达式匹配
     * 实现支持 '.' 和 '*' 的正则表达式匹配。
     * '.' 匹配任意单个字符。
     * '*' 匹配零个或多个前面的元素。
     * 匹配应该覆盖整个输入字符串（不是部分字符串）。
     * <p>
     * 函数:
     * bool isMatch(const char *s, const char *p)
     * <p>
     * 例子:
     * isMatch("aa","a") → false
     * isMatch("aa","aa") → true
     * isMatch("aaa","aa") → false
     * isMatch("aa", "a*") → true
     * isMatch("aa", ".*") → true
     * isMatch("ab", ".*") → true
     * isMatch("aab", "c*a*b") → true
     * <p>
     * * @param s
     *
     * @param p
     * @return
     */
    public boolean isMatch1(String s, String p) {
        //TODO
        return true;
    }

    /**
     * 实现一个支持 '?' 和 '*' 的通配符匹配。
     * '?' 匹配任何单个字符。
     * '*' 匹配任何数量的字符 (包括0个)。
     * <p>
     * 匹配应覆盖 整个 输入字符串（而不是部分）。
     * 这个函数原型为：
     * bool isMatch(const char *s, const char *p)
     * <p>
     * 示例：
     * isMatch("aa","a") → false
     * isMatch("aa","aa") → true
     * isMatch("aaa","aa") → false
     * isMatch("aa", "*") → true
     * isMatch("aa", "a*") → true
     * isMatch("ab", "?*") → true
     * isMatch("aab", "c*a*b") → false
     *
     * @param s
     * @param p
     * @return
     */

    public boolean isMatch2(String s, String p) {
        //TODO
        return true;
    }

}