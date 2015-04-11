package com.zil.li.DP;

/**
 * Created by youlongli on 3/14/15.
 *
 * Ref: http://leetcode.tgic.me/best-time-to-buy-and-sell-stock-iv/index.html
 */
public class BestTimeToBuyAndSellStockIV {
  public int maxProfitA(int k, int[] prices) {
    if (prices.length < 1) {
      return 0;
    }

    if (k > prices.length / 2) {
      return quickSolve(prices);
    }

    int n = prices.length;
    // Global_ij -> The max profit for i transactions in j days.
    int[][] global = new int[k + 1][n];
    // Local_ij -> The max profit for i transactions in j days where the last transaction sells on the last day.
    int[][] local = new int[k + 1][n];

    for (int i = 1; i <= k; i++) {
      for (int j = 1; j < n; j++) {
        int diff = prices[j] - prices[j - 1];
        local[i][j] = Math.max(local[i][j - 1] + diff, global[i - 1][j - 1]);
        global[i][j] = Math.max(local[i][j], global[i][j - 1]);
      }
    }

    return global[k][n - 1];
  }

  public int maxProfitB(int k, int[] prices) {
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
