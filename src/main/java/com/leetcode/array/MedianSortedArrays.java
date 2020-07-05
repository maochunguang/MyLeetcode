package com.leetcode.array;

/**
 * @author mao
 * Date：2020/7/5
 * Description：【4】寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * <p>
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * Related Topics 数组 二分查找 分治算法
 */
public class MedianSortedArrays {
    /**
     * 归并排序后直接计算中位数
     * 执行耗时:2 ms,击败了100.00% 的Java用户
     * 内存消耗:40.8 MB,击败了100.00% 的Java用户
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 返回中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                nums[k++] = nums2[j++];
            } else {
                nums[k++] = nums1[i++];
            }
        }
        while (i < nums1.length) {
            nums[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            nums[k++] = nums2[j++];
        }
        double median = 0.0;
        if (nums.length % 2 == 0) {
            median = ((double) nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2;
        } else {
            median = nums[nums.length / 2];
        }

        return median;
    }
}
