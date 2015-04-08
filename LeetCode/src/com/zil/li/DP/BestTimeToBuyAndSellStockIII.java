package com.zil.li.DP;

/**
 * Created by youlongli on 2/22/15.
 *
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class BestTimeToBuyAndSellStockIII {
  /**
   * Idea: In order to find two transaction to maximize the profit, we can think it of finding the maximum profit single transaction for two arrays separately.
   *
   * Hence we can use DP to compute the largest single transaction from left and right for a certain end/split point (where we cut the array into two...).
   */
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length < 2) {
      return 0;
    }

    int n = prices.length;
    int[] left = new int[n];
    int[] right = new int[n];
    int min = prices[0];
    int max = prices[n - 1];

    // Left
    left[0] = 0;
    for (int i = 1; i < n; i++) {
      int profit = prices[i] - min;
      left[i] = Math.max(left[i - 1], profit);
      min = Math.min(min, prices[i]);
    }

    // Right
    right[n - 1] = 0;
    for (int i = n - 2; i >= 0; i--) {
      int profit = max - prices[i];
      right[i] = Math.max(right[i + 1], profit);
      max = Math.max(max, prices[i]);
    }

    int maxProfit = 0;
    for (int i = 0; i < n; i++) {
      maxProfit = Math.max(maxProfit, left[i] + right[i]);
    }

    return maxProfit;
  }
}
