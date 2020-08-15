package com.leetcode.string;

/**
 * @author mao
 * Date：2020/8/15
 * Description：[38]外观数列
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项
 * 注意：整数序列中的每一项将表示为一个字符串。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * <p>
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * 输入: 1
 * 输出: "1"
 * 解释：这是一个基本样例。
 * <p>
 * 示例 2:
 * 输入: 4
 * 输出: "1211"
 * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似
 * "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 * Related Topics 字符串
 */
public class CountAndSay {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countAndSay(n));
    }

    /**
     * 动态规划解决外观数列
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        // 1,2,11,22> 11,12,21,22
        String[] dp = new String[n + 1];
        dp[0] = "0";
        dp[1] = "1";

        for (int i = 2; i < dp.length; i++) {
            String s = dp[i - 1];
            char cur = s.charAt(0);
            StringBuilder sb = new StringBuilder();
            int p1 = 0;
            int j = 1;
            for (j = 1; j < s.length(); j++) {
                if (cur != s.charAt(j)) {
                    int count = j - p1;
                    sb.append(count).append(cur);
                    p1 = j;
                    cur = s.charAt(j);
                }
            }
            if (p1 != j) {
                int count = j - p1;
                sb.append(count).append(cur);
            }

            dp[i] = sb.toString();
        }
        return dp[n];
    }
}
