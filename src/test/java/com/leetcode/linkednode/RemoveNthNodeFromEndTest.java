package com.leetcode.linkednode;

import org.junit.Test;

public class RemoveNthNodeFromEndTest {
    private static final RemoveNthNodeFromEnd removeNode = new RemoveNthNodeFromEnd();


    @Test
    public void removeNthFromEnd() {
        ListNode head1 = ListNodeHelper.createFakeNodeList(6);
        ListNode head2 = ListNodeHelper.createFakeNodeList(2);
        ListNode removedNode1 = removeNode.removeNthFromEnd(head1,2);
        ListNode removedNode2 = removeNode.removeNthFromEnd(head2,1);
        ListNodeHelper.printNode(removedNode1);
        ListNodeHelper.printNode(removedNode2);

    }
}