package com.zil.li.DP;

/**
 * Created by youlongli on 2/26/15.
 *
 * http://www.cnblogs.com/yuzhangcmu/p/4196373.html
 */
public class DistinctSubsequences {
  public int numDistinct(String S, String T) {
    if (S == null || T == null) {
      return 0;
    }

    int lenS = S.length();
    int lenT = T.length();
    int[][] dp = new int[lenS + 1][lenT + 1];

    if (lenT > lenS) {
      return 0;
    }

    for (int i = 0; i <= lenS; i++) {
      for (int j = 0; j <= lenT; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = 1;
        } else if (i == 0) {
          dp[i][j] = 0;
        } else if (j == 0) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i - 1][j] + (S.charAt(i - 1) == T.charAt(j - 1) ? dp[i - 1][j - 1] : 0);
        }
      }
    }

    return dp[lenS][lenT];
  }
}
