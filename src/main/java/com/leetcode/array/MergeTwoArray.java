package com.leetcode.array;

import java.util.Arrays;

/**
 * @author maocg
 * Date：2018/4/6
 * Description：
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1中，使得 num1 成为一个有序数组。
 * 注意:你可以假设 nums1有足够的空间（空间大小大于或等于m + n）来保存 nums2 中的元素。
 * 在 nums1 和 nums2 中初始化的元素的数量分别是 m 和 n。
 */
public class MergeTwoArray {
    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num2 = new int[]{3, 8, 11};
        System.out.println("before sort:" + Arrays.toString(num1));
        merge(num1, num1.length, num2, num2.length);
        System.out.println("after sort:" + Arrays.toString(num1));
    }

    /**
     * 注意题目，m和n为实际排序的长度
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        int k1 = 0, k2 = 0, k = 0;
        while (k1 < m && k2 < n) {
            if (nums1[k1] > nums2[k2]) {
                temp[k++] = nums2[k2++];
            } else {
                temp[k++] = nums1[k1++];
            }
        }
        while (k1 < m) {
            temp[k++] = nums1[k1++];
        }
        while (k2 < n) {
            temp[k++] = nums2[k2++];
        }
        for (int i = 0; i < k; i++) {
            nums1[i] = temp[i];
        }
    }

}