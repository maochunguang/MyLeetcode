package com.leetcode.linkednode;

/**
 * @author mao
 * Date：2020/7/5
 * Description：
 * [19]给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 说明：
 * 给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 * Related Topics 链表 双指针
 */
public class RemoveNthNodeFromEnd {

    /**
     * 注意临界条件：
     * [1,2],1 删除最后一个，
     * [1]，1删除一个，变成空列表
     * @param head 链表
     * @param n，倒数第n个
     * @return 返回链表
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
