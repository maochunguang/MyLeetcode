package com.leetcode.sort;

import java.util.Arrays;

/**
 * @author mao
 * Date：2020/8/8
 * Description：归并排序
 */
public class MergeSort {
    private static void sort(int[] a, int low, int high) {
        if (high > low) {
            int mid = (high + low) / 2;
            sort(a, low, mid);
            sort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    //两路归并
    private static void merge(int[] a, int low, int mid, int high) {
        // 复制到aux[]
        int[] temp = new int[a.length];
        int p1 = low, p2 = mid + 1, k = low;//p1、p2是检测指针，k是存放指针
        // 合并回 a[],i代表左边数组下标，j带有右边数组下标
        while (p1 <= mid && p2 <= high) {
            if (a[p1] <= a[p2]) {
                temp[k++] = a[p1++];
            } else {
                temp[k++] = a[p2++];
            }
        }
        while (p1 <= mid) {
            temp[k++] = a[p1++];
        }
        while (p2 <= high) {
            temp[k++] = a[p2++];
        }
        //copy到原数组
        for (int i = low; i <= high; i++) {
            a[i] = temp[i];
        }
    }


    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 4, 78, 34, 12, 64, 1, 8};
        System.out.println("排序之前：");
        System.out.println(Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println("排序之后：");
        System.out.println(Arrays.toString(arr));
    }
}
