package com.leetcode.linkednode;

/**
 * @author maocg
 * Date：2018/4/6
 * Description：
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 例如，下面的两个链表：
 * A:  a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:  b1 → b2 → b3
 * 在节点 c1 开始相交。
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存
 */
public class IntersectLinkedNode {
    /**
     * 解法：两个指针同时走，先走到最后的指针，指向另一个链表的head。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }

}