package com.zil.li.DP;

/**
 * Created by youlongli on 2/22/15.
 *
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length < 2) {
      return 0;
    }

    int min = prices[0];
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      int profit = prices[i] - min;
      maxProfit = Math.max(maxProfit, profit);
      min = Math.min(min, prices[i]);
    }

    return maxProfit;
  }
}
