package com.leetcode.string;

import org.junit.Test;

public class StrMultiplyTest {
    private static final StrMultiply multiply = new StrMultiply();


    @Test
    public void multiply() {
        String num1 = "123";
        String num2 = "7";
        String num3 = "144";
        String num4 = "33";
        System.out.println(multiply.multiply(num1, num2));
        System.out.println(multiply.multiply(num1, num3));
        System.out.println(multiply.multiply(num1, num4));
        System.out.println(multiply.multiply(num2, num3));
        System.out.println(multiply.multiply(num2, num4));
        System.out.println(multiply.multiply(num3, num4));
    }
}