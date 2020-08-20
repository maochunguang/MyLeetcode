package com.leetcode.utils;

/**
 * @author mao
 * Date：2020/8/20
 * Description：
 */
public class Swap {
    public static void swapArr(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
