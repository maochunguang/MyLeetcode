package com.mcg.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author maocg
 * Date：2018/4/6
 * Description：
 * 给定一个有序数组，你需要原地删除其中的重复内容，使每个元素只出现一次,并返回新的长度。
 * 不要另外定义一个数组，您必须通过用 O(1) 额外内存原地修改输入的数组来做到这一点。
 * <p>
 * 示例：
 * <p>
 * 给定数组: nums = [1,1,2],
 * 你的函数应该返回新长度 2, 并且原数组nums的前两个元素必须是1和2
 * 不需要理会新的数组长度后面的元素
 */
public class RemoveDuplicatesOfArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int temp = nums[0];
        int len = nums.length;
        //{1, 2, 2, 4, 5, 6}
        for (int i = 1; i < len; i++) {
            if (nums[i] == temp) {
                for (int j = i; j < len - 1; j++) {
                    int tem = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tem;
                }
                len--;
                i--;
            } else {
                temp = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return len;
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int len = nums.length;
        //{1, 2, 2, 4, 5, 6}
        for (int i = 1; i < len; i++) {
            if (nums[i] == val) {
                for (int j = i; j < len - 1; j++) {
                    int tem = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tem;
                }
                len--;
                i--;
            }
        }
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < len; i++) {
//            System.out.println(nums[i]);
        }
        return len;
    }

    @Test
    public void testRemoveElement() {
        int[] a = {1, 2, 2, 4, 5, 6};
        int[] b = {1, 1, 1, 1, 2, 6};
        int[] c = {1, 2, 2};
        int[] d = {1, 2, 2, 6, 6};
        int[] e = {1, 1, 1};
        String aa ="aaaa";
        System.out.println(aa.indexOf("aa"));
        Assert.assertTrue(removeElement(a, 2) == 5);
        Assert.assertTrue(removeElement(b, 1) == 3);
        Assert.assertTrue(removeElement(c, 2) == 2);
        Assert.assertTrue(removeElement(d, 6) == 4);
        Assert.assertTrue(removeElement(e, 1) == 1);
    }

    @Test
    public void testRemoveDuplicates() {
        int[] a = {1, 2, 2, 4, 5, 6};
        int[] b = {1, 1, 1, 1, 2, 6};
        int[] c = {1, 2, 2};
        int[] d = {1, 2, 2, 6, 6};
        int[] e = {1, 1, 1};
        Assert.assertTrue(removeDuplicates(a) == 5);
        Assert.assertTrue(removeDuplicates(b) == 3);
        Assert.assertTrue(removeDuplicates(c) == 2);
        Assert.assertTrue(removeDuplicates(d) == 3);
        Assert.assertTrue(removeDuplicates(e) == 1);
    }
}