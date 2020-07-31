package com.leetcode.string;

import org.junit.Test;

public class CommonPrefixTest {
    private static final CommonPrefix commonPrefix = new CommonPrefix();

    @Test
    public void longestCommonPrefix() {
        String[] strs = new String[]{"", "", "", ""};
        System.out.println(commonPrefix.longestCommonPrefix(strs));
    }
}