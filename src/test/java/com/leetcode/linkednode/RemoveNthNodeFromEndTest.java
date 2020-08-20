package com.leetcode.linkednode;

import com.leetcode.utils.FakerData;
import com.leetcode.utils.PrintHelper;
import org.junit.Test;

public class RemoveNthNodeFromEndTest {
    private static final RemoveNthNodeFromEnd removeNode = new RemoveNthNodeFromEnd();


    @Test
    public void removeNthFromEnd() {
        ListNode head1 = FakerData.initNodeList(6);
        ListNode head2 = FakerData.initNodeList(2);
        ListNode removedNode1 = removeNode.removeNthFromEnd(head1,2);
        ListNode removedNode2 = removeNode.removeNthFromEnd(head2,1);
        PrintHelper.printNode(removedNode1);
        PrintHelper.printNode(removedNode2);

    }
}