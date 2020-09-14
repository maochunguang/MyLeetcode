package com.leetcode.linkednode;

import com.leetcode.utils.FakerData;
import com.leetcode.utils.PrintHelper;

/**
 * @author maocg
 * Date：2018/4/7
 * Description：TODO
 * 给定两个非空链表来代表两个非负整数，位数按照逆序方式存储，它们的每个节点只存储单个数字。
 * 将这两数相加会返回一个新的链表。你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class TwoLinkedNodeSum {
    public static void main(String[] args) {
        TwoLinkedNodeSum nodeSum = new TwoLinkedNodeSum();
        ListNode l1 = FakerData.initNodeFromArr(new int[]{1});
        ListNode l2 = FakerData.initNodeFromArr(new int[]{9, 9});

        PrintHelper.printNode(nodeSum.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode pre = new ListNode(-1);
        ListNode preHead = pre;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            carry = val / 10;
            pre.next = new ListNode(val % 10);
            l1 = l1.next;
            l2 = l2.next;
            pre = pre.next;
        }
        ListNode l3 = l1 == null ? l2 : l1;
        while (l3 != null) {
            int val = l3.val + carry;
            carry = val / 10;
            pre.next = new ListNode(val % 10);
            pre = pre.next;
            l3 = l3.next;
        }
        if (carry > 0) {
            pre.next = new ListNode(carry);
        }

        return preHead.next;
    }
}