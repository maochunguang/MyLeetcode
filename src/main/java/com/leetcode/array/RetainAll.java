package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mao
 * Date：2020/8/16
 * Description：两个有序数组求交集
 */
public class RetainAll {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 5, 6};
        int[] arr2 = new int[]{3, 6, 8, 9};
        System.out.println(Arrays.toString(retainAll(arr1, arr2)));

    }

    public static int[] retainAll(int[] array1, int[] array2) {
        if (array1 == null || array1.length == 0) {
            return array1;
        }
        if (array2 == null || array2.length == 0) {
            return array2;
        }
        List<Integer> result = new ArrayList<>();
        for (int a : array1) {
            if (binSearch(array2, a) >= 0) {
                result.add(a);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    public static int binSearch(int[] array, int a) {
        int low = 0;
        int high = array.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] > a) {
                high = mid - 1;
            } else if (array[mid] < a) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 使用异或运算符
     *
     * @param char1
     * @param char2
     * @return
     */
    public static char find(char[] char1, char[] char2) {
        int a = 0;
        for (char c : char1) {
            a = a ^ c;
        }
        for (char c : char2) {
            a = a ^ c;
        }
        return (char) (a);
    }
}