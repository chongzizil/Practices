package com.zil.li.DP;

/**
 * Created by youlongli on 2/26/15.
 *
 * https://leetcode.com/problems/distinct-subsequences/
 *
 * Ref:
 * http://www.cnblogs.com/yuzhangcmu/p/4196373.html
 * https://leetcode.com/discuss/26680/easy-to-understand-dp-in-java
 */
public class DistinctSubsequences {
  public int numDistinct(String S, String T) {
    if (S == null || T == null) {
      return 0;
    }

    int lenS = S.length();
    int lenT = T.length();

    int[][] dp = new int[lenT + 1][lenS + 1];

    // When T's length is 0, the result will be 1. (First row)
    // When S's length is 0, the result will be 0. (First col)
    for (int i = 0; i <= lenS; i++) {
      dp[0][i] = 1;
    }

    for (int i = 1; i <= lenT; i++) {
      for (int j = 1; j <= lenS; j++) {
        if (T.charAt(i - 1) == S.charAt(j - 1)) {
          // We either use the character in both string or do not use the character in S.
          dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
        } else {
          // We do not use the character in S.
          dp[i][j] = dp[i][j - 1];
        }
      }
    }

    return dp[lenT][lenS];
  }
}
