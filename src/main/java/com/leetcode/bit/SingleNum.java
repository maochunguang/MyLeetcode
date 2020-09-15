package com.leetcode.bit;

/**
 * @author mao
 * Date：2020/8/23
 * Description：[136]给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。
 * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNum {

    public static void main(String[] args) {
        SingleNum singleNum = new SingleNum();
        int[] nums = new int[]{1, 1, 2, 1};
        int[] nums1 = new int[]{1, 1, 2, 1, 2, 3, 2};
        System.out.println(singleNum.singleNumber2(nums));
        System.out.println(singleNum.singleNumber2(nums1));
    }

    /**
     * 使用异或运算
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = sum ^ nums[i];
        }
        return sum;
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
     * 说明：你的算法应该具有线性时间复杂度。你可以不使用额外空间来实现吗？
     * 示例 1:
     * 输入: [2,2,3,2]
     * 输出: 3
     *
     * 示例 2:
     * 输入: [0,1,0,1,0,1,99]
     * 输出: 99
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int a = 0, b = 0;
        for (int next : nums) {
            b = (b ^ next) & ~a;
            a = (a ^ next) & ~b;
            System.out.println("a==" + a + "; b==" + b);
        }
        return b;
    }

}
