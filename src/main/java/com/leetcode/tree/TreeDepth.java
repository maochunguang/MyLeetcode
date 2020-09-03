package com.leetcode.tree;

import com.leetcode.utils.FakerData;

/**
 * @author mao
 * Date：2020/8/22
 * Description：【104】求二叉树最大高度
 */
public class TreeDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }

        return minDepth + 1;
    }

    public static void main(String[] args) {
        TreeDepth treeDepth = new TreeDepth();
        TreeNode treeNode = FakerData.initNotBTree();
        System.out.println(treeDepth.maxDepth(treeNode));
        System.out.println(treeDepth.minDepth(treeNode));
    }
}
