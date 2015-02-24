package com.zil.li.DP;

/**
 * Created by youlongli on 2/23/15.
 *
 * https://oj.leetcode.com/problems/scramble-string/
 *
 * http://www.cnblogs.com/yuzhangcmu/p/4189152.html
 */
public class ScrambleString {
  public boolean isScramble(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() != s2.length()) {
      return false;
    }

    int n = s1.length();
    int[][][] dp = new int[n][n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          dp[i][j][k] = -1;
        }
      }
    }

    return helper(s1, 0, s2, 0, n, dp);
  }

  // len is the length of the string, since s1 and s2 are originals...
  private boolean helper(String s1, int index1, String s2, int index2, int len, int[][][] dp) {
    if (len == 1) {
      return s1.charAt(index1) == s2.charAt(index2);
    }

    int res = dp[index1][index2][len - 1];
    if (res != -1) {
      return res == 1;
    }

    res = 0;

    for (int i = 1; i < len; i++) {
      // Check s1 left & s2 left, s1 right & s2 right
      if (helper(s1, index1, s2, index2, i, dp)
          && helper(s1, index1 + i, s2, index2 + i, len - i, dp)) {
        res = 1;
        break;
      }

      // Check s1 left & s2 right, s1 right & s2 left
      if (helper(s1, index1, s2, index2 + len - i, i, dp)
          && helper(s1, index1 + i, s2, index2, len - i, dp)) {
        res = 1;
        break;
      }
    }

    dp[index1][index2][len - 1] = res;
    return res == 1;
  }
}
