package com.leetcode.dynamic;

/**
 * @author mao
 * Date：2020/9/10
 * Description：一个环上有10个点,编号为0-9,从0点出发,每步可以顺时针到下一个点,
 * 也可以逆时针到上一个点,求:经过n步又回到0点有多少种不同的走法？
 *
 * 举例
 * 如果n=1，则从0出发只能到1或者9，不可能回到0，共0种走法
 * 如果n=2，则从0出发有4条路径:0->1->2, 0->1->0, 0->9->8, 0->9->0,
 * 其中有两条回到了0点，故一共有2种走法
 */
public class CycleSteps {
    public static void main(String[] args) {
        CycleSteps steps = new CycleSteps();
        System.out.println(steps.getSteps(10, 2));
        System.out.println(steps.getSteps(10, 3));
        System.out.println(steps.getSteps(10, 4));
        System.out.println(steps.getSteps(10, 6));
    }

    /**
     * 通用解法，d(k,j)代表经过k步，到j点的所有解法
     * 状态方程为：d(k, j) = d(k-1, j-1) + d(k-1, j+1);
     * 由于可能发生越界，故转换为
     * d(k, j) = d(k-1, (j-1+n)%n) + d(k-1, (j+1)%n);
     * @param n 环数
     * @param k 步数
     * @return 走法
     */
    public int getSteps(int n, int k) {
        if (n == 1) return 0;
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int j = 1; j <= k; j++) {
            for (int i = 0; i < n; i++) {
                if (k % 2 == 1) {
                    dp[j][i] = 0;
                } else {
                    dp[j][i] = dp[j - 1][(i - 1 + n) % n] + dp[j - 1][(i + 1) % n];
                }
            }
        }

        return dp[k][0];

    }
}
