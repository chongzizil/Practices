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
   * Hence we can use DP to compute the largest single transaction from left and right for a certain end point (where we cut the array into two...).
   */
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int n = prices.length;
    int[] l = new int[n];
    int[] r = new int[n];
    int min = prices[0];
    int max = prices[n - 1];
    int res = 0;

    // Left part
    for (int i = 1; i < n; i++) {
      l[i] = Math.max(l[i - 1], prices[i] - min);
      min = Math.min(min, prices[i]);
    }

    // Right part
    for (int i = n - 2; i >= 0; i--) {
      r[i] = Math.max(r[i + 1], max - prices[i]);
      max = Math.max(max, prices[i]);
    }

    for (int i = 0; i < n; i++) {
      res = Math.max(res, l[i] + r[i]);
    }

    return res;
  }
}
