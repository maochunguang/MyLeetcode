package com.leetcode.linkednode;

import java.util.Random;

/**
 * @author mao
 * Date：2020/7/5
 * Description：单链表Helper类，生成链表，打印链表
 */
public class ListNodeHelper {

    public static ListNode createFakeNodeList(int len) {
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
        printNode(head);
        return head;
    }

    public static void printNode(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.value);
            if (node.next != null) {
                sb.append("->");
            }
            node = node.next;
        }
        System.out.println(sb.toString());

    }
}
