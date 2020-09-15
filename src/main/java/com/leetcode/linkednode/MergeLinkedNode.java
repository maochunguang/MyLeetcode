package com.leetcode.linkednode;

import com.leetcode.utils.FakerData;
import com.leetcode.utils.PrintHelper;

/**
 * @author maocg
 * Date：2018/4/6
 * Description：【21】合并两个已排序的链表，并将其作为一个新列表返回。新列表应该通过拼接前两个列表的节点来完成。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeLinkedNode {
    public static void main(String[] args) {
        MergeLinkedNode mergeLinkedNode = new MergeLinkedNode();
        ListNode l1 = FakerData.initNodeFromArr(new int[]{1, 3, 5, 7});
        ListNode l2 = FakerData.initNodeFromArr(new int[]{2, 6, 8});
        ListNode l3 = FakerData.initNodeFromArr(new int[]{4, 9, 11});
        ListNode[] listNodes = new ListNode[]{l1, l2, l3};
        PrintHelper.printNode(mergeLinkedNode.mergeKLists(listNodes));
        PrintHelper.printNode(mergeLinkedNode.mergeTwoListsRe(l1, l2));
        PrintHelper.printNode(mergeLinkedNode.mergeTwoListsRe(l2, l3));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;

        }
        pre.next = l1 == null ? l2 : l1;

        return preHead.next;
    }

    /**
     * 递归实现
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsRe(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 合并k个链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        ListNode preHeader = pre;
        ListNode cur = lists[0];
        pre.next = cur;
        for (int i = 1; i < lists.length; i++) {
            pre.next = mergeTwoLists(cur, lists[i]);
            cur = pre.next;
        }

        return preHeader.next;
    }
}