package com.leetcode.string;

import org.junit.Test;

public class ReverseWordTest {
    public static final ReverseWord reverseWord = new ReverseWord();

    @Test
    public void reverseWords() {
        String s1 = "your  are my  baby ";
        String s2 = " hello  world  my  baby  ";
        String s3 = "  your  are my  son  ";
        String s4 = " hello  my  baby";
        System.out.println(reverseWord.reverseWords(s1));
        System.out.println(reverseWord.reverseWords(s2));
        System.out.println(reverseWord.reverseWords(s3));
        System.out.println(reverseWord.reverseWords(s4));
    }
}