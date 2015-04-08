package com.zil.li.DP;

/**
 * Created by youlongli on 4/6/15.
 *
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {
  /**
   * Dynamic programing. DP_i represents the maximum money for ending at house i.
   * Space complexity: O(n)
   *
   * DP_0 means 0 house, so DP_0 = 0;
   * DP_1 means first house only, so DP_1 = num[1]
   * Then the equation for DP_i is either rob ith house or not -> DP_i = max(DP_(i - 2) + num[i - 1], dp[i - 1]).
   */
  public int robA(int[] num) {
    int n = num.length;
    int[] dp = new int[n + 1];

    if (num.length == 0) {
      return 0;
    }

    dp[0] = 0;
    dp[1] = num[0];

    for (int i = 2; i <= n; i++) {
      dp[i] = Math.max(num[i - 1] + dp[i - 2], dp[i - 1]);
    }

    return dp[n];
  }

  /**
   * Space complexity: O(1)
   * Since we only need three variables...
   */
  public int robB(int[] num) {
    int n = num.length;

    if (num.length == 0) {
      return 0;
    }

    int prevPrev = 0;
    int prev = num[0];
    int now = prev;

    for (int i = 2; i <= n; i++) {
      now = Math.max(num[i - 1] + prevPrev, prev);
      prevPrev = prev;
      prev = now;
    }

    return now;
  }
}
