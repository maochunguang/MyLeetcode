package com.leetcode.linkednode;

/**
 * @author maocg
 * Date：2018/4/6
 * Description：
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 例如，下面的两个链表：
 * A:  a1 → a2
 *                  ↘
 *                      c1 → c2 → c3
 *                  ↗
 * B:  b1 → b2 → b3
 * 在节点 c1 开始相交。
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存
 */
public class IntersectLinkedNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // TODO

        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}