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
    int[] l = new int[n];
    int[] r = new int[n];

    // Left
    l[0] = 0;
    int min = prices[0];
    for (int i = 1; i < n; i++) {
      min = Math.min(min, prices[i]);
      l[i] = Math.max(l[i - 1], prices[i] - min);
    }

    // Right
    r[n - 1] = 0;
    int max = prices[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      max = Math.max(max, prices[i]);
      r[i] = Math.max(r[i + 1], max - prices[i]);
    }

    int res = 0;
    for (int i = 0; i < n; i++) {
      res = Math.max(res, l[i] + r[i]);
    }

    return res;
  }
}
