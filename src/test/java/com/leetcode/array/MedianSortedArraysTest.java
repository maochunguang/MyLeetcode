package com.leetcode.array;

import org.junit.Test;

public class MedianSortedArraysTest {
    private static final MedianSortedArrays sortedArrays = new MedianSortedArrays();

    @Test
    public void findMedianSortedArrays() {
        int[] num1 = new int[]{1, 3};
        int[] num2 = new int[]{2, 4, 9};
        int[] num3 = new int[]{3, 5, 7};
        int[] num4 = new int[]{6, 8, 11};
        System.out.println(sortedArrays.findMedianSortedArrays(num1,num2));
        System.out.println(sortedArrays.findMedianSortedArrays(num1,num3));
        System.out.println(sortedArrays.findMedianSortedArrays(num1,num4));
        System.out.println(sortedArrays.findMedianSortedArrays(num3,num2));
        System.out.println(sortedArrays.findMedianSortedArrays(num4,num2));
        System.out.println(sortedArrays.findMedianSortedArrays(num4,num3));

    }
}