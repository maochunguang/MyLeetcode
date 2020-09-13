package com.leetcode.dynamic;

import java.util.Arrays;

/**
 * @author mao
 * Date：2020/9/13
 * Description：子序列问题
 * 最长上升子序列(LISLIS):LongestLongest IncreasingIncreasing SubsequenceSubsequence
 * 最长连续序列(LCSLCS):LongestLongest ConsecutiveConsecutive SequenceSequence
 * 最长连续递增序列(LCISLCIS):LongestLongest ContinuousContinuous IncreasingIncreasing SubsequenceSubsequence
 * 最长公共子序列(LCSLCS): LongestLongest CommonCommon SubsequenceSubsequence
 */
public class LongestSubSeq {

    public static void main(String[] args) {
        LongestSubSeq subSeq = new LongestSubSeq();
        int[] nums1 = new int[]{1, 8, 5, 6, 7};
        System.out.println(subSeq.findLengthOfLCIS(nums1));
        System.out.println(subSeq.findLengthOfLCIS1(nums1));
    }

    /**
     * [674]给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度
     * 示例 1:
     * 输入: [1,3,5,4,7]
     * 输出: 3
     * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
     * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
     *
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLen = 0;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return maxLen;
    }

    public int findLengthOfLCIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxLen = 1;
        int dp_i = 1;
        int dp_i_1 = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp_i = dp_i_1 + 1;
                dp_i_1 = dp_i;
            } else {
                dp_i_1 = 1;
                dp_i = 1;
            }
            maxLen = Math.max(maxLen, dp_i);

        }
        return maxLen;
    }

    /**
     * [673]给定一个未排序的整数数组，找到最长递增子序列的个数。
     *
     * 示例 1:
     *
     * 输入: [1,3,5,4,7]
     * 输出: 2
     * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
     * 示例 2:
     *
     * 输入: [2,2,2,2,2]
     * 输出: 5
     * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        int[] count = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int res = 0;

        for (int i = 0; i < len; i++) {
            if (dp[i] == max) {
                res += count[i];
            }
        }
        return res;
    }

}
