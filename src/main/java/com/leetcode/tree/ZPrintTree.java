package com.leetcode.tree;

import com.leetcode.utils.FakerData;

import java.util.Stack;

/**
 * z字型打印二叉树
 */
public class ZPrintTree {
    public static void main(String[] args) {
        System.out.println("start");
        TreeNode treeNode = FakerData.initTree();
        printTree(treeNode);

    }

    /**
     * 用两个栈解决螺旋打印问题
     * @param treeNode 二叉树
     */
    public static void printTree(TreeNode treeNode) {
        if (treeNode == null) return;
        Stack<TreeNode> oddStack = new Stack<>(); // 奇数栈
        Stack<TreeNode> evenStack = new Stack<>(); // 偶数栈

        oddStack.push(treeNode); // 根节点算奇数行, 先把根节点入奇数栈

        TreeNode tempTreeNode = null; // 临时节点
        while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
            while (!oddStack.isEmpty()) {
                tempTreeNode = oddStack.pop();
                System.out.println(tempTreeNode.value + ", ");

                if (tempTreeNode.right != null) {
                    evenStack.push(tempTreeNode.right);
                }
                if (tempTreeNode.left != null) {
                    evenStack.push(tempTreeNode.left);
                }
            }
            while (!evenStack.isEmpty()) {
                tempTreeNode = evenStack.pop();
                System.out.println(tempTreeNode.value + ", ");
                if (tempTreeNode.left != null) {
                    oddStack.push(tempTreeNode.left);
                }
                if (tempTreeNode.right != null) {
                    oddStack.add(tempTreeNode.right);
                }

            }
        }

    }

}

