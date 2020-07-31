package com.leetcode.string;

/**
 * @author mao
 * Date：2020/7/31
 * Description：【415】给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 例子：
 * num1：“123”，num2：“34”
 * 结果：“157”
 * 你不能使用任何內建 BigInteger 库，也不能直接将输入的字符串转换为整数形式。
 * <p>
 * Related Topics 字符串
 */
public class AddStrings {
    /**
     * 补零法
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings1(String num1, String num2) {
        if (num1.equals("0") && num2.equals("0")) {
            return "0";
        }
        int len = Math.max(num1.length(), num2.length());
        int gap = Math.abs(num1.length() - num2.length());
        if (num1.length() > num2.length()) {
            for (int i = 0; i < gap; i++) {
                num2 = "0" + num2;
            }
        } else if (num1.length() < num2.length()) {
            for (int i = 0; i < gap; i++) {
                num1 = "0" + num1;
            }
        }
        int[] res = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            int n1, n2;
            n1 = num1.charAt(i) - '0';
            n2 = num2.charAt(i) - '0';
            int sum = n1 + n2 + res[i + 1];
            res[i + 1] = sum % 10;
            res[i] += sum / 10;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }

    /**
     * 双指针解法
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1) res.append(1);
        return res.reverse().toString();
    }
}
