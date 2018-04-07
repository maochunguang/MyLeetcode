package com.mcg.integer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author maocg
 * Date：2018/4/5
 * Description：TODO
 * 给定一个范围为 32 位 int 的整数，将其颠倒。
 * <p>
 * 例 1:
 * 输入: 123
 * 输出:  321
 * <p>
 * 例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 例 3:
 * 输入: 120
 * 输出: 21
 */
public class ReverseInt {
    public int reverse(int n) {
        int num = 0;
        boolean isPlus = true;
        if (n < 0) {
            n = -n;
            isPlus = false;
        }
        while (n > 0) {
            num = num * 10 + (n % 10);
            n = n / 10;
        }
        if (!isPlus){
            num = -num;
        }

        return num > Integer.MAX_VALUE ? 0 : num;
    }

    public int reverse2(int n) {
        boolean isPlus = true;
        if (n < 0) {
            n = -n;
            isPlus = false;
        }
        String num = n + "";
        StringBuffer sb = new StringBuffer();
        for (int i = num.length() - 1; i >= 0; i--) {
            sb.append(num.charAt(i));
        }
        int result = 0;
        try {
            result = Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return result;
        }

        return isPlus ? result : -result;
    }


    public static void main(String[] args) {
        System.out.println(123 % 10);
    }

    @Test
    public void testReverse() {
        int a = 12345167;
        int b = 2333;
        int c = -123;
        int d = 0;
        Assert.assertEquals(reverse(a),76154321);
        Assert.assertEquals(reverse(b),3332);
        Assert.assertEquals(reverse(c),-321);
        Assert.assertEquals(reverse(d),0);

        Assert.assertEquals(reverse2(a),76154321);
        Assert.assertEquals(reverse2(b),3332);
        Assert.assertEquals(reverse2(c),-321);
        Assert.assertEquals(reverse2(d),0);

    }
}