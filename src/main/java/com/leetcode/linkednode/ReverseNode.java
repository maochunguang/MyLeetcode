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
        ListNode node1 = FakerData.initNodeList(6);
        ListNode node2 = FakerData.initNodeList(7);
        PrintHelper.printNode(reverseNode.reverseList(node));
        PrintHelper.printNode(reverseNode.reverseBetween(node1, 1, 3));
        PrintHelper.printNode(reverseNode.reverseKGroup(node2, 2));

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            //更新指针位置
            prev = cur;
            cur = next;
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
        ListNode res = new ListNode(-1);
        res.next = head;

        ListNode node = res;
        for (int i = 1; i < m; i++) {
            node = node.next;
        }
        ListNode nextHead = node.next;
        ListNode pre = null;
        ListNode next = null;

        for (int i = m; i <= n; i++) {
            next = nextHead.next;
            nextHead.next = pre;
            pre = nextHead;
            nextHead = next;

        }
        node.next.next = next;
        node.next = pre;

        return res.next;
    }

    ListNode reverse(ListNode a, ListNode b) {
        ListNode prev = null;
        ListNode cur = a;
        ListNode next = a;
        while (cur != b) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * [25]给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 示例：
     * 给你这个链表：1->2->3->4->5
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    // pre cur
    // -1-> 1->2->3->4, 2->1->4->3
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode first = cur;
            ListNode second = cur.next;
            //两两交换节点
            pre.next = second;
            first.next = second.next;
            second.next = first;

            pre = first;
            cur = first.next;

        }

        return preHead.next;
    }
}
