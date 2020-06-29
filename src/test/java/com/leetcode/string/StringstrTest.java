package com.leetcode.string;

import org.junit.Test;

public class StringstrTest {
    public static final Stringstr stringStr = new Stringstr();

    @Test
    public void strStr() {
        String haystack = "adfsdfsdwer";
        String haystack1="mississippi";
        String s1 = "sdf";
        String s2 = "ssdf";
        String s3 = "we";
        String s4 = "sd";
        String s5 = "issip";
        System.out.println(stringStr.strStr(haystack, s1));
        System.out.println(stringStr.strStr(haystack, s2));
        System.out.println(stringStr.strStr(haystack, s3));
        System.out.println(stringStr.strStr(haystack, s4));
        System.out.println(stringStr.strStr(haystack1, s5));
        System.out.println(stringStr.strStr1(haystack, s1));
        System.out.println(stringStr.strStr1(haystack, s2));
        System.out.println(stringStr.strStr1(haystack, s3));
        System.out.println(stringStr.strStr1(haystack, s4));
        System.out.println(stringStr.strStr1(haystack1, s5));
    }
}