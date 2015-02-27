package com.zil.li.DP;

/**
 * Created by youlongli on 2/26/15.
 *
 * http://www.cnblogs.com/yuzhangcmu/p/4148892.html
 */
public class PalindromePartitioningII {
  public int minCut(String s) {
    int n = s.length();
    int[] minCut = new int[n + 1];
    boolean[][] isPalindrome = checkPalindrome(s);

    // If left part length is 0.. It means the whole string is palindrome, so set minCut[0] = -1 which + 1 will result in 0...
    minCut[0] = -1;
    for (int l = 1; l <= n; l++) {
      minCut[l] = l - 1;
      for (int i = 0; i <= l - 1; i++) {
        int j = l - 1;
        if (isPalindrome[i][j]) {
          minCut[l] = Math.min(minCut[l], minCut[i] + 1);
        }
      }
    }

    return minCut[n];
  }

  private boolean[][] checkPalindrome(String s) {
    int n = s.length();
    boolean[][] res = new boolean[n][n];

    for (int l = 1; l <= n; l++) {
      for (int i = 0; i < n - l + 1; i++) {
        int j = i + l - 1;
        if (l == 1) {
          res[i][j] = true;
        } else {
          res[i][j] = s.charAt(i) == s.charAt(j) && (l <= 2 || res[i + 1][j - 1]);
        }
      }
    }

    return res;
  }
}
