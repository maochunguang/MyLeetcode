package com.leetcode.tree;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int value;

    TreeNode(int value) {
        this.value = value;
    }

    /**
     * 初始化二叉树数据
     * 1
     * 2   3
     * 7 6 5 4
     *
     * @return 二叉树
     */
    public static TreeNode init() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
//        root.left.left.left = new TreeNode(8);
//        root.left.left.right = new TreeNode(9);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        // 返回根节点
        return root;
    }
}
