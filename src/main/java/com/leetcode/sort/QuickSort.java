package com.leetcode.sort;

import com.leetcode.utils.Swap;

import java.util.Arrays;

/**
 * @author mao
 * Date：2020/8/8
 * Description：快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[]{10, 4, 23, 17, 9, 2, 6};
        System.out.println("排序之前：" + Arrays.toString(a));

        quickSort(a, 0, a.length - 1);
        System.out.println("排序之后：" + Arrays.toString(a));

    }

    public static void quickSort(int[] a, int low, int high) {
        if (a == null || a.length == 0) return;
        if (low < high) {
            int mid = findMid(a, low, high);
            quickSort(a, low, mid - 1);
            quickSort(a, mid + 1, high);
        }

    }

    private static int findMid(int[] a, int low, int high) {
        int base = a[low];
        int left = low;
        while (low < high) {
            while (low < high && a[high] > base) {
                high--;
            }
            while (low < high && a[low] <= base) {
                low++;
            }
            if (low < high) {
                Swap.swapArr(a, low, high);
            }
        }
        a[left] = a[low];
        a[low] = base;

        return low;
    }


}
