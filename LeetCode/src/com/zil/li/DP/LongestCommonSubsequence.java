package com.zil.li.DP;

/**
 * Created by youlongli on 3/11/15.
 *
 * http://www.lintcode.com/en/problem/longest-common-subsequence/
 */
public class LongestCommonSubsequence {
  public int longestCommonSubsequence(String A, String B) {
    // write your code here
    if (A == null || B == null) {
      return 0;
    }

    int lenA = A.length();
    int lenB = B.length();
    int[][] dp = new int[lenA + 1][lenB + 1];

    for (int i = 0; i <= lenA; i++) {
      for (int j = 0; j <= lenB; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else {
          if (A.charAt(i - 1) == B.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
          } else {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
          }
        }
      }
    }

    return dp[lenA][lenB];
  }
}
