package com.leetcode.backtrack;

import java.util.*;

/**
 * @author mao
 * Date：2020/9/13
 * Description：[46]给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutation {
    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        int[] nums1 = new int[]{2, 3, 5, 6};
        int[] nums2 = new int[]{2, 3, 5};
        int[] nums3 = new int[]{2, 3};
        System.out.println(permutation.permute(nums1));
        System.out.println(permutation.permuteDfs(nums1));
        System.out.println(permutation.permute(nums2));
        System.out.println(permutation.permuteDfs(nums2));
        System.out.println(permutation.permute(nums3));
        System.out.println(permutation.permuteDfs(nums3));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        int len = nums.length;
        backTrack(res, output, 0, len);
        return res;
    }

    public void backTrack(List<List<Integer>> res, List<Integer> output, int first, int n) {
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            backTrack(res, output, first + 1, n);
            Collections.swap(output, first, i);
        }
    }

    public List<List<Integer>> permuteDfs(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        int len = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int depth = 0;
        boolean[] used = new boolean[len];
        dfs(res, used, depth, stack, len, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, boolean[] used, int depth, Deque<Integer> stack, int len, int[] nums) {
        if (depth == len) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            stack.addLast(nums[i]);
            used[i] = true;
            dfs(res, used, depth + 1, stack, len, nums);
            stack.removeLast();
            used[i] = false;
        }
    }

    public List<List<Integer>> permuteDfsUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        //后面剪枝需要按排序的顺序
        Arrays.sort(nums);
        int len = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int depth = 0;
        boolean[] used = new boolean[len];
        dfs(res, used, depth, stack, len, nums);
        return res;
    }

    private void dfsUnique(List<List<Integer>> res, boolean[] used, int depth, Deque<Integer> stack, int len, int[] nums) {
        if (depth == len) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            //剪枝条件判断：
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            stack.addLast(nums[i]);
            used[i] = true;
            dfsUnique(res, used, depth + 1, stack, len, nums);
            stack.removeLast();
            used[i] = false;
        }
    }
}
