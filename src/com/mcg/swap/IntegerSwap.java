package com.mcg.swap;

import org.junit.Test;

/**
 * @author maocg
 * Date：2018/3/27
 * Description：TODO
 */
public class IntegerSwap {
    /**
     * 方法一：使用^操作
     *
     * @param a
     * @param b
     */
    public void swapInt(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);

    }

    public void swapIntByAddOrSub(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a);
        System.out.println(b);

    }


    @Test
    public void testSwapInt() {
        swapInt(10, 15);
        swapIntByAddOrSub(20, 12);
    }

}