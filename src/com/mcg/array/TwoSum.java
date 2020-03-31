package com.mcg.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author maocg
 * Date：2018/3/21
 * Description：TODO
 */
public class TwoSum {
    /**
     * 穷举法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len && j != i; j++) {
                if (nums[i] + nums[j] == target) {
                    if (i > j) {
                        return new int[]{j, i};
                    } else {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }

    @Test
    public void testTwoSum() {
        int[] nums = new int[]{2, 7, 11, 15, 17};
        int target = 26;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}