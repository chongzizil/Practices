package com.zil.li.DP;

import java.util.Arrays;

/**
 * Created by youlongli on 3/2/15.
 *
 * http://www.lintcode.com/en/problem/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
  public int longestIncreasingSubsequence(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int res = 0;
    int n = nums.length;
    int[] dp = new int[n]; // DP_i represents the max length if i is the last number of the sequence.
    Arrays.fill(dp, 1); // Initial

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] <= nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      res = Math.max(res, dp[i]);
    }

    return res;
  }
}
