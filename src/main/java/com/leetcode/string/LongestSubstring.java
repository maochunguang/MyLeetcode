package com.leetcode.string;

import java.util.HashMap;

/**
 * @author mao
 * Date：2020/7/5
 * Description：【3】无重复字符的最长字串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * Related Topics 哈希表 双指针 字符串 Sliding Window
 */
public class LongestSubstring {
    /**
     * 使用hash表，遇到重复字符串进行回溯，回溯到重复字符串下一位
     * <p>
     * 执行耗时:97 ms,击败了16.23% 的Java用户
     * 内存消耗:40.6 MB,击败了5.20% 的Java用户
     *
     * @param s 输入字符串
     * @return 输出长度
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int index = 0;
        char[] strs = s.toCharArray();
        while (index < s.length()) {
            char str = strs[index];
            if (map.containsKey(str)) {
                max = Math.max(map.size(), max);
                index = map.get(str);
                map.clear();
            } else {
                map.put(str, index);
                max = Math.max(map.size(), max);
            }
            index++;
        }
        return max;
    }

    /**
     * 使用数组桶代替hashmap
     *
     * @param s 输入字符串
     * @return 输出长度
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s.isEmpty())
            return 0;


        return 0;
    }
}