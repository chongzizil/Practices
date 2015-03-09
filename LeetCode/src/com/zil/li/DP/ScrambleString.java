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
    int[][][] mem = new int[n][n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          mem[i][j][k] = -1; // Initial set
        }
      }
    }

    return helper(s1, s2, 0, 0, n, mem);
  }

  private boolean helper(String s1, String s2, int i, int j, int len, int[][][] mem) {
    if (mem[i][j][len - 1] != -1) {
      return mem[i][j][len - 1] == 1;
    }

    if (len == 1) {
      return s1.charAt(i) == s2.charAt(j);
    }

    // First check if the two string are identical, although without this part the code still works.
    if (s1.substring(i, i + len).equals(s2.substring(j, j + len))) {
      mem[i][j][len - 1] = 1;
      return mem[i][j][len - 1] == 1;
    }

    mem[i][j][len - 1] = 0;

    for (int l = 1; l < len; l++) {
      // Left-Left, Right-Right
      if (helper(s1, s2, i, j, l, mem) && helper(s1, s2, i + l, j + l, len - l, mem)) {
        mem[i][j][len - 1] = 1;
        return mem[i][j][len - 1] == 1;
      }

      // Left-Right, Left-Right
      if (helper(s1, s2, i, j + len - l, l, mem) && helper(s1, s2, i + l, j, len - l, mem)) {
        mem[i][j][len - 1] = 1;
        return mem[i][j][len - 1] == 1;
      }
    }

    return mem[i][j][len - 1] == 1;
  }
}
