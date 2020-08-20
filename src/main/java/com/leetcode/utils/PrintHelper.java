package com.leetcode.utils;

import com.leetcode.linkednode.ListNode;
import com.leetcode.tree.TreeNode;

import java.util.Stack;

/**
 * @author mao
 * Date：2020/7/5
 * Description：单链表Helper类，生成链表，打印链表
 */
public class PrintHelper {
    public static void main(String[] args) {
        TreeNode treeNode = FakerData.initTree();
        printTree(treeNode);
    }
    public static void printNode(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.value);
            if (node.next != null) {
                sb.append("->");
            }
            node = node.next;
        }
        System.out.println(sb.toString());

    }

    public static void printTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int level = 0;
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                while (!stack.isEmpty()) {
                    TreeNode printNode = stack.pop();
                    System.out.print("  " + printNode.value + "  ");
                }
                System.out.println();
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            } else {
                node = stack.pop();

            }

        }
    }
}
