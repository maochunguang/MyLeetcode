package com.leetcode.string;

import org.junit.Test;

public class AddStringsTest {
    public static final AddStrings addStrings = new AddStrings();

    @Test
    public void addStrings() {
        String num1 = "123";
        String num2 = "72";
        String num3 = "194";
        String num4 = "99";
        System.out.println(addStrings.addStrings(num1, num2));
        System.out.println(addStrings.addStrings(num1, num3));
        System.out.println(addStrings.addStrings(num1, num4));
        System.out.println(addStrings.addStrings(num2, num3));
        System.out.println(addStrings.addStrings(num2, num4));
        System.out.println(addStrings.addStrings(num3, num4));

        System.out.println(addStrings.addStrings1(num1, num2));
        System.out.println(addStrings.addStrings1(num1, num3));
        System.out.println(addStrings.addStrings1(num1, num4));
        System.out.println(addStrings.addStrings1(num2, num3));
        System.out.println(addStrings.addStrings1(num2, num4));
        System.out.println(addStrings.addStrings1(num3, num4));
    }
}