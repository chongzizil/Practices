package com.zil.li.DP;

/**
 * Created by youlongli on 2/22/15.
 *
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) { // Note: prices.length should be at least 1
      return 0;
    }

    int res = 0;
    int min = prices[0];

    for (int i = 1; i < prices.length; i++) {
      res = Math.max(res, prices[i] - min);
      min = Math.min(min, prices[i]);
    }

    return res;
  }
}
