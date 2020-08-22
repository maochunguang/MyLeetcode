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

    public static void main(String[] args) {
        TreeDepth treeDepth = new TreeDepth();
        TreeNode treeNode = FakerData.initTree();
        System.out.println(treeDepth.maxDepth(treeNode));
    }
}
