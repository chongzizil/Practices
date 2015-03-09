package com.zil.li.DP;

import java.util.Set;

/**
 * Created by youlongli on 2/22/15.
 *
 * https://oj.leetcode.com/problems/word-break/
 */
public class WordBreak {
  public boolean wordBreak(String s, Set<String> dict) {
    if (s == null || s.length() == 0) {
      return false;
    }

    int n = s.length();
    boolean[][] dp = new boolean[n][n];

    for (int l = 1; l <= n; l++) {
      for (int i = 0; i < n - l + 1; i++) {
        int j = i + l - 1;
        if (dict.contains(s.substring(i, j + 1))) {
          dp[i][j] = true;
        } else {
          dp[i][j] = false;
          for (int k = i; k < j; k++) {
            dp[i][j] = dp[i][j] || (dp[i][k] && dp[k + 1][j]);
          }
        }
      }
    }

    return dp[0][n - 1];
  }
}
