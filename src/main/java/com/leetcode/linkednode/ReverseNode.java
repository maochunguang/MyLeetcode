package com.leetcode.linkednode;

import com.leetcode.utils.FakerData;
import com.leetcode.utils.PrintHelper;

/**
 * [206]反转一个单链表。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseNode {
    public static void main(String[] args) {
        ReverseNode reverseNode = new ReverseNode();
        ListNode node = FakerData.initNodeList(7);
        PrintHelper.printNode(reverseNode.reverseList(node));

    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev =cur;
            cur =next;
        }
        return prev;
    }

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     *
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     * @param head 头结点
     * @param m 开始
     * @param n 结束
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null;
        ListNode cur = head;
        int index = 1;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev =cur;
            cur =next;
        }
        return prev;
    }
}
