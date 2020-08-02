package com.leetcode.string;

/**
 * @author mao
 * Date：2020/8/2
 * Description：[151]给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * <p>
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 进阶：
 * <p>
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 * Related Topics 字符串
 */

public class ReverseWord {
    /**
     * 需要注意反转后的字符串不能有多余的空格
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        System.out.println(s.trim());
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            if (word.isEmpty() || word.trim().isEmpty()) {
                continue;
            }
            sb.append(word.trim());
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
