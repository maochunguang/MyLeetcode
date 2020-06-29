package com.leetcode.string;

/**
 * @author mao
 * Date：2020/6/29
 * Description：【28】【easy】实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle
 * 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
 * <p>
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * <p>
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。
 * 这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * Related Topics 双指针 字符串
 */

public class Stringstr {
    /**
     * 滑动窗口
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.7 MB,击败了5.43% 的Java用户
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int m = needle.length(), n = haystack.length();

        for (int start = 0; start < n - m + 1; ++start) {
            if (haystack.substring(start, start + m).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

    /**
     * 双指针
     * 执行耗时:2 ms,击败了48.78% 的Java用户
     * 内存消耗:38.3 MB,击败了5.43% 的Java用户
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() == 0) return -1;
        int l1 = haystack.length();
        int l2 = needle.length();

        for (int i = 0; i <= l1 - l2; ++i) {
            int k = i, j = 0;
            while (j < l2 && k < l1 && haystack.charAt(k) == needle.charAt(j)) {
                j++;
                k++;
            }
            if (j == l2) {
                return i;
            }
        }

        return -1;
    }
}
