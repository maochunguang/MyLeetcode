package com.leetcode.linkednode;

import com.leetcode.utils.FakerData;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mao
 * Date：2020/8/20
 * Description：找出单链表的环
 */
public class CycleNode {
    public static void main(String[] args) {
        CycleNode cycleNode = new CycleNode();
        ListNode node = FakerData.initCycleNodeList();
        System.out.println(cycleNode.hasCycle(node));
    }
    /**
     * 快慢指针法
     *
     * @param head 头节点
     * @return True 有环
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;

        }
        return false;
    }

    private boolean hashSolution(ListNode head) {
        if (head == null || head.next == null)
            return false;
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

}
