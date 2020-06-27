package com.leetcode.alicode;

import org.junit.Before;
import org.junit.Test;

public class NumberTransferTest {
    private NumberTransfer numberTransfer;

    @Before
    public void setUp() throws Exception {
        numberTransfer = new NumberTransfer();
    }

    @Test
    public void numberToChinese() {
        int[] nums = new int[]{304, 4006, 4000, 10003, 10030, 21010011, 101101101};
        for (int num : nums) {
            System.out.println(numberTransfer.numberToChinese(num));
        }
    }

}