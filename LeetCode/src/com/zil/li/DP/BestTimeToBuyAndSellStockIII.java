package com.zil.li.DP;

/**
 * Created by youlongli on 2/22/15.
 */
public class BestTimeToBuyAndSellStockIII {
  /**
   * Idea: In order to find two transaction to maximize the profit, we can think it of finding the maximum profit single transaction for two arrays separately.
   *
   * Hence we can use DP to compute the largest single transaction from left and right for a certain end point (where we cut the array into two...).
   */
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int n = prices.length;
    int[] left = new int[n];
    int[] right = new int[n];

    int min = prices[0];
    left[0] = 0;
    for (int i = 1; i < n; i++) {
      left[i] = Math.max(prices[i] - min, left[i - 1]);
      min = Math.min(prices[i], min);
    }

    int max = prices[n - 1];
    right[n - 1] = 0;
    for (int i = n - 2; i >= 0; i--) {
      right[i] = Math.max(max - prices[i], right[i + 1]);
      max = Math.max(prices[i], max);
    }

    int res = 0;
    for (int i = 0; i < n; i++) {
      res = Math.max(res, left[i] + right[i]);
    }

    return res;
  }
}
