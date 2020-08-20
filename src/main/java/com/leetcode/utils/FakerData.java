package com.leetcode.utils;

import com.leetcode.linkednode.ListNode;
import com.leetcode.tree.TreeNode;

import java.util.Random;

/**
 * @author mao
 * Date：2020/8/20
 * Description：
 */
public class FakerData {
    /**
     * 初始化二叉树数据
     * 1
     * 2  3
     * 7 6 5 4
     *
     * @return 二叉树
     */
    public static TreeNode initTree() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        // 返回根节点
        return root;
    }

    public static ListNode initNodeList(int len) {
        Random random = new Random();
        int randomNum = random.nextInt(len);
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int i = 0; i < len - 1; i++) {
            ListNode node = new ListNode(randomNum + i);
            if (curr.next == null) {
                curr.next = node;
            } else {
                while (curr.next != null) curr = curr.next;
                curr.next = node;
            }
        }
        PrintHelper.printNode(head);
        return head;
    }

    public static ListNode initCycleNodeList() {
        ListNode head = new ListNode(0);
        ListNode l1 = new ListNode(2);
        head.next = l1;
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(5);
        l2.next = l3;
        ListNode l4 = new ListNode(6);
        l3.next = l4;
        ListNode l5 = new ListNode(7);
        l4.next = l5;
        l5.next = l3;
//        PrintHelper.printNode(head);
        return head;
    }
}
