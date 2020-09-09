package com.leetcode.dynamic;

/**
 * 股票交易系列题目【121】【122】，及解法
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * <p>
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * Related Topics 数组 动态规划
 */
public class StockTrading {
    public static void main(String[] args) {
        StockTrading stockTrading = new StockTrading();
        int[] prices1 = {9, 4, 1, 5, 7, 10};
        int[] prices2 = {3, 4, 1, 5, 7, 9};
        System.out.println(stockTrading.maxProfit(prices1));
        System.out.println(stockTrading.maxProfit(prices2));
        System.out.println(stockTrading.maxProfit_K_1(prices1));
        System.out.println(stockTrading.maxProfit_K_1(prices2));
        System.out.println(stockTrading.maxProfit_K_inf(prices1));
        System.out.println(stockTrading.maxProfit_K_inf(prices2));
    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice >= maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    /**
     * 使用动态规划解决,
     * dp[i][k][0 or 1]
     * 0 <= i <= n-1, 1 <= k <= K, 0代表卖出1代表持有
     * n 为天数，大 K 为最多交易数
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+price[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0]-price[i])
     * k=1时：
     * dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1]+price[i])
     * dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0]-price[i])
     * <p>
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1]+price[i])
     * dp[i][1] = max(dp[i-1][1], -price[i])
     * <p>
     * dp_i_0 = max(dp_i_0, dp_i_1+price[i])
     * dp_i_1 = max(dp_i_1, -price[i])
     *
     * @param prices
     * @return
     */
    public int maxProfit_K_1(int[] prices) {


        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }

    /**
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     * = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])
     * <p>
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
     * <p>
     * dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
     * dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
     *
     * @param prices
     * @return
     */
    public int maxProfit_K_inf(int[] prices) {
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }
}
