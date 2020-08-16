package com.leetcode.array;

import java.util.*;

/**
 * @author mao
 * Date：2020/8/16
 * Description：
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

    public static char find(char[] char1, char[] char2) {
        for (char c : char1) {
            if (Arrays.binarySearch(char2, c) < 0) {
                return c;
            }
        }
        return 0;
    }
}