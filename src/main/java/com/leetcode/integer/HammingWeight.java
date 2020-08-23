package com.leetcode.integer;

/**
 * @author mao
 * Date：2020/8/23
 * Description：
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

}
