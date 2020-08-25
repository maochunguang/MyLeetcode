package com.leetcode.utils;

import com.leetcode.linkednode.ListNode;
import com.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
            sb.append(node.val);
            if (node.next != null) {
                sb.append("->");
            }
            node = node.next;
        }
        System.out.println(sb.toString());

    }

    public static void printTree(TreeNode root) {
        List<TreeNode> stack = new ArrayList<>();
        stack.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = stack.remove(0);
                level.add(node.val);

                if (node.left != null) {
                    stack.add(node.left);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }
            }
            res.add(level);
        }

        System.out.println(res.toString());
    }

}
