package com.leetcode.sort;

import java.util.Arrays;

/**
 * @author mao
 * Date：2020/8/8
 * Description：
 */
public class BubbleSort {
    private static void bubbleSort(int a[], int n) {
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 4, 78, 34, 12, 64, 1, 8};
        bubbleSort(arr, arr.length);
        System.out.println("排序之后：");
        System.out.println(Arrays.toString(arr));
    }
}
