package com.leetcode.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromeTest {

    @Test
    public void longestPalindrome() {
        LongestPalindrome palindrome = new LongestPalindrome();
        String s1 = "abaaaccc";
        String s2 = "abcddbcaeef";
        String s3 = "aaccbbccrr";
        String s4 = "efpabcb";
        System.out.println(palindrome.longestPalindrome(s1));
        System.out.println(palindrome.longestPalindrome(s2));
        System.out.println(palindrome.longestPalindrome(s3));
        System.out.println(palindrome.longestPalindrome(s4));
    }
}