package com.leetcode.tree;

import com.leetcode.utils.FakerData;

import java.util.Stack;

/**
 * @author mao
 * Date：2020/8/17
 * Description：二叉树基本操作，前序，中序，后序遍历
 */
public class BinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = FakerData.initTree();
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.preOrderTraverse1(treeNode);
    }

    /**
     * 先序遍历递归版本
     * 访问顺序：先根节点，再左子树，最后右子树
     *
     * @param root
     */
    public void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.println(root.value);
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }

    /**
     * 先序遍历，非递归版本，用栈
     * 1
     * 2   3
     * 7 6 5 4
     *
     * @param root 二叉树
     */
    public void preOrderTraverse2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                System.out.print(node.value + " -> ");
                stack.push(node);
                node = node.left;
            } else {
                TreeNode temp = stack.pop();
                node = temp.right;
            }
        }
    }

    /**
     * 中序遍历
     * 访问顺序：先左子树，再根节点，最后右子树
     *
     * @param root
     */
    public void inOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.println(root.left);
            preOrderTraverse1(root);
            preOrderTraverse1(root.right);
        }
    }

    /**
     * 后序遍历
     * 访问顺序：先左子树，再右子树，最后根节点
     *
     * @param root
     */
    public void postOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.println(root.left);
            preOrderTraverse1(root.right);
            preOrderTraverse1(root);
        }
    }
}
