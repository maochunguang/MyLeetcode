package com.leetcode.linkednode;

import org.junit.Test;

import static org.junit.Assert.*;

public class DescSearchNodeTest {
    private static final DescSearchNode descSearchNode = new DescSearchNode();

    @Test
    public void findDescEle() {

            Node node = Node.createFakeNode();
            System.out.println(descSearchNode.findDescEle(node, 2).value);
            System.out.println(descSearchNode.findDescEle(node, 3).value);
            System.out.println(descSearchNode.findDescEle(node, 4).value);
            System.out.println(descSearchNode.findDescEle(node, 5).value);

    }
}