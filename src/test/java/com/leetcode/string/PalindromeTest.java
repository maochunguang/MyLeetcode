package com.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeTest {

    @Test
    public void isPalindrome1() {
        Palindrome palindrome = new Palindrome();
        int num1 = 121;
        int num2 = 12114;
        int num3 = -121;
        int num4 = 1221;
        int num5 = -1221;
        int num6 = 12121;
        Assert.assertTrue(palindrome.isPalindrome1(num1));
        Assert.assertFalse(palindrome.isPalindrome1(num2));
        Assert.assertFalse(palindrome.isPalindrome1(num3));
        Assert.assertTrue(palindrome.isPalindrome1(num4));
        Assert.assertFalse(palindrome.isPalindrome1(num5));
        Assert.assertTrue(palindrome.isPalindrome1(num6));
    }
    @Test
    public void isPalindrome2() {
        Palindrome palindrome = new Palindrome();
        int num1 = 121;
        int num2 = 12114;
        int num3 = -121;
        int num4 = 1221;
        int num5 = -1221;
        int num6 = 12121;
        Assert.assertTrue(palindrome.isPalindrome2(num1));
        Assert.assertFalse(palindrome.isPalindrome2(num2));
        Assert.assertFalse(palindrome.isPalindrome2(num3));
        Assert.assertTrue(palindrome.isPalindrome2(num4));
        Assert.assertFalse(palindrome.isPalindrome2(num5));
        Assert.assertTrue(palindrome.isPalindrome2(num6));
    }

}