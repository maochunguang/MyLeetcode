package com.leetcode.tree;

import com.leetcode.utils.FakerData;

import java.util.ArrayList;
import java.util.List;

/**
 * 【230】给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 */
public class Kthsmallest {
    public static void main(String[] args) {
        Kthsmallest kthsmallest = new Kthsmallest();
        TreeNode treeNode = FakerData.initBSTree();
        System.out.println(kthsmallest.kthSmallest(treeNode, 3));
        System.out.println(kthsmallest.kthSmallest(treeNode, 2));
        System.out.println(kthsmallest.kthSmallest(treeNode, 4));
        System.out.println(kthsmallest.kthLargest(treeNode, 1));
        System.out.println(kthsmallest.kthLargest(treeNode, 2));
        System.out.println(kthsmallest.kthLargest(treeNode, 3));

    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        inOrderHelper(root, res);
        System.out.println(res);
        return res.get(k - 1);
    }

    public int kthLargest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        inOrderHelper(root, res);
        return res.get(res.size() - k);
    }

    public void inOrderHelper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                inOrderHelper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                inOrderHelper(root.right, res);
            }
        }
    }

}
