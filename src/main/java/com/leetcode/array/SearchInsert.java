package com.leetcode.array;

/**
 * @author mao
 * Date：2020/8/28
 * Description：[35]给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 */
public class SearchInsert {
    public static void main(String[] args) {
        SearchInsert insert = new SearchInsert();
        int[] arr = new int[]{2, 4, 6, 8, 9, 14};
        System.out.println(insert.searchInsert(arr, 3));
        System.out.println(insert.searchInsert(arr, 5));
        System.out.println(insert.searchInsert(arr, 8));
        System.out.println(insert.searchInsert(arr, 11));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
