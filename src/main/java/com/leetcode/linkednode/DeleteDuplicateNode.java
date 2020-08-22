package com.leetcode.linkednode;

import com.leetcode.utils.FakerData;
import com.leetcode.utils.PrintHelper;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mao
 * Date：2020/8/22
 * Description：[83]给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * <p>
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class DeleteDuplicateNode {
    public static void main(String[] args) {
        DeleteDuplicateNode duplicateNode = new DeleteDuplicateNode();
        ListNode node1 = FakerData.initNodeFromArr(new int[]{1, 2, 3, 3});
        ListNode node2 = FakerData.initNodeFromArr(new int[]{1, 3, 3, 5, 7});
        ListNode node3 = FakerData.initNodeFromArr(new int[]{1, 1, 3, 3, 4});
        PrintHelper.printNode(duplicateNode.deleteDuplicates1(node1));
        PrintHelper.printNode(duplicateNode.deleteDuplicates1(node2));
        PrintHelper.printNode(duplicateNode.deleteDuplicates1(node3));

    }

    /**
     * 删除无序链表
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode pre = head;
        Set<Integer> nodeSet = new HashSet<>();
        while (cur != null) {
            if (nodeSet.contains(cur.value)) {
                pre.next = cur.next;
            } else {
                nodeSet.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 删除有序链表
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.value == cur.next.value) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
