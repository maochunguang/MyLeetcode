package com.leetcode.bit;

/**
 * @author mao
 * Date：2020/8/23
 * Description：【191】二进制中1的个数
 */
public class HammingWeight {
    /**
     * 二进制中一的个数
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

}
