package com.zil.li.DP;

/**
 * Created by youlongli on 2/22/15.
 *
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int res = 0;
    int min = prices[0];

    for (int i = 1; i < prices.length; i++) {
      min = prices[i] < min ? prices[i] : min;
      res = Math.max(prices[i] - min, res);
    }

    return res;
  }
}
