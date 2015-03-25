package com.zil.li.DP;

/**
 * Created by youlongli on 3/14/15.
 *
 * Ref: https://leetcode.com/discuss/25603/a-concise-dp-solution-in-java
 */
public class BestTimeToBuyAndSellStockIV {
  public int maxProfit(int k, int[] prices) {
    if (prices.length < 1) {
      return 0;
    }

    if (k > prices.length / 2) {
      return quickSolve(prices);
    }

    int n = prices.length;
    int[][] dp = new int[k + 1][n];

    for (int i = 1; i <= k; i++) {
      int currMaxBalance = -prices[0];
      for (int j = 1; j < n; j++) {
        dp[i][j] = Math.max(dp[i][j - 1], currMaxBalance + prices[j]);
        currMaxBalance = Math.max(currMaxBalance, dp[i - 1][j - 1] - prices[j]);
      }
    }

    return dp[k][n - 1];
  }

  private int quickSolve(int prices[]) {
    int res = 0;
    for (int i = 1; i < prices.length; i++) {
      int profit = prices[i] - prices[i - 1];
      if (profit > 0) {
        res += profit;
      }
    }
    return res;
  }
}
