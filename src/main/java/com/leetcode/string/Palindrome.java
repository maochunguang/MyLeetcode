package com.leetcode.string;


/**
 * [9]判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * 输入: 121
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 * Related Topics 数学
 */
public class Palindrome {
    /**
     * 第一种方式，数字转为字符串判断
     * 执行耗时:10 ms,击败了64.88% 的Java用户
     * 内存消耗:39.1 MB,击败了5.14% 的Java用户
     *
     * @param num 输入整数
     * @return 返回true false
     */
    public boolean isPalindrome1(int num) {
        if (num < 0) {
            return false;
        }
        char[] nums = String.valueOf(num).toCharArray();
        int len = nums.length;
        for (int i = 0; i < len / 2; i++) {
            if (nums[i] != nums[len - i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 第二种方案：整数除法,121
     * 执行耗时:10 ms,击败了64.88% 的Java用户
     * 内存消耗:39.2 MB,击败了5.14% 的Java用户
     *
     * @param x 整数
     * @return true
     */
    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        while (x / div >= 10) div = div * 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div = div / 100;
        }
        return true;
    }

    /**
     * 第三种反转数字解法
     * 执行耗时:9 ms,击败了98.85% 的Java用户
     * 内存消耗:38.9 MB,击败了5.14% 的Java用户
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    /**
     * [125]验证回文串，
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * 示例 1:
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: "race a car"
     * 输出: false
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

}
