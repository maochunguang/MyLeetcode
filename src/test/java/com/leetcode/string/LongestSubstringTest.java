package com.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringTest {
    private static final LongestSubstring subString = new LongestSubstring();

    @Test
    public void lengthOfLongestSubstring() {
        String st1 = "alkwderdsfse";
        String st2 = "allammlgb";
        String st3 = "abcdderdsll";
        Assert.assertEquals(7, subString.lengthOfLongestSubstring(st1));
        Assert.assertEquals(4, subString.lengthOfLongestSubstring(st2));
        Assert.assertEquals(5, subString.lengthOfLongestSubstring(st3));
    }

    @Test
    public void lengthOfLongestSubstring1() {
        String st1 = "alkwderdsfse";
        String st2 = "allammlgb";
        String st3 = "abcdderdsll";
        Assert.assertEquals(7, subString.lengthOfLongestSubstring1(st1));
        Assert.assertEquals(4, subString.lengthOfLongestSubstring1(st2));
        Assert.assertEquals(5, subString.lengthOfLongestSubstring1(st3));
    }

}