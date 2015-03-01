package com.zil.li.DP;

/**
 * Created by youlongli on 2/26/15.
 */
public class InterleavingString {
  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
      return false;
    }

    int[][] mem = new int[s1.length() + 1][s2.length() + 1];
    for (int i = 0; i <= s1.length(); i++) {
      for (int j = 0; j <= s2.length(); j++) {
        mem[i][j] = -1; // init
      }
    }

    return helper(s1, 0, s2, 0, s3, 0, mem);
  }

  private boolean helper(String s1, int i, String s2, int j, String s3, int k, int[][] mem) {
    if (mem[i][j] != -1) {
      return mem[i][j] == 1;
    }

    int len1 = s1.length();
    int len2 = s2.length();

    if (i == len1 && j == len2) {
      mem[i][j] = 1;
      return mem[i][j] == 1;
    }

    mem[i][j] = 0;
    if (i < len1 && s1.charAt(i) == s3.charAt(k)) {
      mem[i][j] = helper(s1, i + 1, s2, j, s3, k + 1, mem) ? 1 : 0;
    }

    if (mem[i][j] == 0 && j < len2 && s2.charAt(j) == s3.charAt(k) ) {
      mem[i][j] = helper(s1, i, s2, j + 1, s3, k + 1, mem) ? 1 : 0;
    }

    return mem[i][j] == 1;
  }
}