package com.leetcode.integer;

/**
 * @author mao
 * Date：2020/8/21
 * Description：[69]实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,由于返回类型是整数，小数部分将被舍去。
 */
public class MySqrt {
    public static void main(String[] args) {
        MySqrt sqrt = new MySqrt();
        System.out.println(sqrt.mySqrt(19));
        System.out.println(sqrt.mySqrt(26));
        System.out.println(sqrt.mySqrt(38));
        System.out.println(sqrt.mySqrt(111));
        System.out.println(sqrt.mySqrt(2));
    }

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid * mid <= x) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    /**
     * 牛顿法
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }

}
