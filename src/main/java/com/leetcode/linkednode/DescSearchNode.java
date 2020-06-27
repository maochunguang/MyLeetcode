package com.leetcode.linkednode;

/**
 * @author maocg
 * Date：2018/3/23
 * 单向链表，如何查找倒数第n个元素?
 * 解答：在查找过程中，设置两个指针，让其中一个指针比另一个指针先前移k-1步，
 * 然后两个指针同时往前移动。循环直到先行的指针指为NULL时，另一个指针所指的位置就是所要找的位置
 */
public class DescSearchNode {
    public Node findDescEle(Node head, int k) {
        if (k < 1 || head == null) {
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        //前移k-1步
        int step = 0;
        for (int i = 0; i < k; i++) {
            step++;
            if (p1.next != null) {
                p1 = p1.next;
            } else {
                return null;
            }
        }
        while (p1 != null) {
            step++;
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println("时间复杂度==" + step);
        return p2;
    }

}

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }

    static Node createFakeNode() {
        Node head = new Node(0);
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);
        Node node8 = new Node(9);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = null;
        head.next = node;
//        printNode(head);
        return head;
    }

    static void printNode(Node node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
}