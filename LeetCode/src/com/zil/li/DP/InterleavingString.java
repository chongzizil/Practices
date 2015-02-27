package com.zil.li.DP;

/**
 * Created by youlongli on 2/26/15.
 */
public class InterleavingString {
  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1 == null || s2 == null || s3 == null) {
      return false;
    }

    int len1 = s1.length();
    int len2 = s2.length();
    int len3 = s3.length();
    int[][] dp = new int[len1 + 1][len2 + 1];

    if (len1 + len2 != len3) {
      return false;
    }

    for (int i = 0; i <= len1; i++) {
      for (int j = 0; j <= len2; j++) {
        dp[i][j] = -1;
      }
    }

    return helper(s1, 0, s2, 0, s3, 0, dp);
  }

  private boolean helper(String s1, int i, String s2, int j, String s3, int k, int[][] dp) {
    if (dp[i][j] != -1) {
      return dp[i][j] == 1;
    }

    int len1 = s1.length();
    int len2 = s2.length();
    int len3 = s3.length();

    // Base case
    if (i == len1 && j == len2 && k == len3) {
      dp[i][j] = 1;
      return true;
    }

    dp[i][j] = 0;
    if (i < len1 && s1.charAt(i) == s3.charAt(k)) {
      dp[i][j] = helper(s1, i + 1, s2, j, s3, k + 1, dp) ? 1 : 0;
    }
    if (dp[i][j] == 0 && j < len2 && s2.charAt(j) == s3.charAt(k)) {
      dp[i][j] = helper(s1, i, s2, j + 1, s3, k + 1, dp) ? 1 : 0;
    }

    return dp[i][j] == 1;
  }
}
