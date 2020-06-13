package com.leetcode.string;


/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * Related Topics 字符串 动态规划
 *
 * @author maocg
 * 寻找最长回文字符
 * 2020-06-13
 */
public class LongestPalindrome {
    /**
     * 假如S = "abaca"
     * dp[0] = "";
     * dp[1] = "";
     * dp[2] = "aba";
     * dp[3] = "aba"
     * dp[4]= "aba"
     *
     * @param s 输入字符串
     * @return 输出回文
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        int begin = 0;
        int maxLen = 1;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }

            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
