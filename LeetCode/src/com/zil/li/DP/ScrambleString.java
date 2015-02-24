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
          // Initial setting
          dp[i][j][k] = -1;
        }
      }
    }

    return check(s1, 0, s2, 0, dp, n);
  }

  private boolean check(String s1, int index1, String s2, int index2, int[][][] dp, int len) {
    if (len == 1) {
      return s1.charAt(index1) == s2.charAt(index2);
    }

    // Be careful... Use len - 1 instead of len!
    int res = dp[index1][index2][len - 1];
    if (res != -1) {
      // true: 1
      return res == 1;
    }

    res = 0;
    for (int i = 1; i < len; i++) {
      if (check(s1, index1, s2, index2, dp, i)
          && check(s1, index1 + i, s2, index2 + i, dp, len - i)) {
        res = 1;
        break;
      }

      if (check(s1, index1, s2, index2 + len - i, dp, i)
          && check(s1, index1 + i, s2, index2, dp, len - i)) {
        res = 1;
        break;
      }
    }

    // true: 1
    dp[index1][index2][len - 1] = res;
    return res == 1;
  }
}
