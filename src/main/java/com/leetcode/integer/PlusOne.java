package com.leetcode.integer;

import java.util.Arrays;

/**
 * @author mao
 * Date：2020/8/23
 * Description：[66]给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {
    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] res = new int[]{2, 9, 9};
        System.out.println(Arrays.toString(plusOne.plusOne(res)));

    }

    public int[] plusOne(int[] digits) {

        int d = 0;
        int size = digits.length;
        int[] res = new int[size + 1];
        int index = res.length - 1;
        int sum = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (i == size - 1) {
                sum = digits[i] + d + 1;
            } else {
                sum = digits[i] + d;
            }
            d = sum / 10;
            res[index--] = sum % 10;
        }
        return res;
    }
}
