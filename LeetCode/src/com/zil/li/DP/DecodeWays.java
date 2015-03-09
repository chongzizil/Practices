package com.zil.li.DP;

/**
 * Created by youlongli on 2/22/15.
 *
 * https://oj.leetcode.com/problems/decode-ways/
 */
public class DecodeWays {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int n = s.length();
    int[] dp = new int[n + 1];

    dp[0] = 1;
    dp[1] = s.charAt(0) == '0' ? 0 : 1; // Note: need to also set dp[1], otherwise s.charAt(i - 2) will throw exception

    for (int i = 2; i <= n; i++) {
      if (s.charAt(i - 1) != '0') {
        dp[i] = dp[i - 1];
      }

      int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
      if (twoDigits >= 10 && twoDigits <= 26) {
        dp[i] += dp[i - 2];
      }
    }

    return dp[n];
  }
}
