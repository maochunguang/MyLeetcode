package com.leetcode.bit;

/**
 * @author mao
 * Date：2020/8/24
 * Description：【231】2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * <p>
 * 示例 1:
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * <p>
 * 示例 2:
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(0xaaaaaaaa);
    }
    /**
     * 2的幂
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     * 四的幂
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
    }

}
