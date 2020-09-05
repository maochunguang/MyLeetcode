package com.leetcode.bit;

import java.util.Arrays;

/**
 * @author mao
 * Date：2020/8/23
 * Description：【191】二进制中1的个数
 */
public class HammingWeight {
    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        for (int i = 0; i <= 10; i++) {
            System.out.println("i==" + i + " 中1的个数是：" + hammingWeight.hammingWeight(i));
        }
        System.out.println(Arrays.toString(hammingWeight.countBits(10)));
    }

    /**
     * 二进制中一的个数
     *
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

    /**
     * 给定一个数字n,统计0~n之间的数字二进制的1的个数，并用数字输出
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        int pow2 = 1;
        int before = 1;
        for (int i = 1; i <= num; i++) {
            if (i == pow2) {
                before = dp[i] = 1;
                pow2 <<= 1;
            } else {
                dp[i] = dp[before] + 1;
                before += 1;
            }
        }
        return dp;
    }

}
