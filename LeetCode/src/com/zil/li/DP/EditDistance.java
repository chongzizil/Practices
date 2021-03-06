package com.zil.li.DP;

/**
 * Created by youlongli on 2/24/15.
 *
 * https://oj.leetcode.com/problems/edit-distance/
 */
public class EditDistance {
  public int minDistance(String word1, String word2) {
    if (word1 == null || word2 == null) {
      return 0;
    }

    int m = word1.length();
    int n = word2.length();

    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        if (i == 0) {
          dp[i][j] = j;
        } else if (j == 0) {
          dp[i][j] = i;
        } else {
          dp[i][j] = Integer.MAX_VALUE;
          if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            // Same
            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
          }
          // Replace
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
          // Insert & Delete
          dp[i][j] = Math.min(dp[i][j], Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
        }
      }
    }

    return dp[m][n];
  }
}
