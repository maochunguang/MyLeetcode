package com.leetcode.array;

import com.leetcode.utils.Swap;

import java.util.Arrays;

/**
 * @author mao
 * Date：2020/8/20
 * Description：把数组分成奇数和偶数两部分
 */
public class SplitArray {
    public static void main(String[] args) {
        SplitArray splitArray = new SplitArray();
        int[] arr = new int[]{1, 12, 4, 6, 7, 8};
        System.out.println(Arrays.toString(splitArray.splitOdd(arr)));

    }

    public int[] splitOdd(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (arr[left] % 2 == 1 && left < right) {
                left++;
            }
            while (arr[right] % 2 == 0 && left < right) {
                right--;
            }
            if (left < right) {
                Swap.swapArr(arr, left, right);
                left++;
                right--;
            }
        }
        return arr;
    }
}
