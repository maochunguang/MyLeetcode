package com.leetcode.array;

/**
 * @author maocg
 * Date：2018/4/6
 * Description：
 * 给定一个数组和一个值，在这个数组中原地移除指定值和返回移除后新的数组长度。
 * 不要为其他数组分配额外空间，你必须使用 O(1) 的额外内存原地修改这个输入数组。
 * 元素的顺序可以改变。超过返回的新的数组长度以外的数据无论是什么都没关系。
 * 示例:
 * 给定 nums = [3,2,2,3]，val = 3，
 * 你的函数应该返回 长度 = 2，数组的前两个元素是 2
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

}