package com.zil.li.DP;

/**
 * Created by youlongli on 2/26/15.
 *
 * https://oj.leetcode.com/problems/wildcard-matching/
 *
 *
 * Idea: Two pointers.. If encounter *, move j to a non * position, remember the pointers and then try. If not match, move i back +1 position and try again.
 */
public class WildcardMatching {
  public boolean isMatch(String s, String p) {
    if (s == null || p == null) {
      return false;
    }

    int lenS = s.length();
    int lenP = p.length();
    int i = 0;
    int j = 0;
    int memI = 0;
    int memJ = 0;
    boolean back = false;

    while (i < lenS) {
      if (j < lenP && matchChar(s.charAt(i), p.charAt(j))) {
        i++;
        j++;
      } else if (j < lenP && p.charAt(j) == '*') {
        while (j < lenP && p.charAt(j) == '*') {
          j++; // Skip all neighbor *
        }

        if (j == lenP) {
          return true; // Remember to check if * cover all sequence of s
        }

        back = true;
        memI = i;
        memJ = j; // j is pointing to a none * character now
      } else if (back) {
        i = ++memI;
        j = memJ;
      } else {
        return false;
      }
    }

    while (j < lenP && p.charAt(j) == '*') {
      j++; // Skip all the rest of *, remember to check
    }

    return j == lenP; // No need to check i because of the while loop
  }

  private boolean matchChar(char c, char p) {
    return c == p || p == '?';
  }

  // Memory exceeds.... Without the array, got TLE...
  public boolean isMatchX(String s, String p) {
    int[][] mem = new int[s.length() + 1][p.length() + 1];

    for (int i = 0; i <= s.length(); i++) {
      for (int j = 0; j <= p.length(); j++) {
        mem[i][j] = -1;
      }
    }

    return helper(s, p, 0, 0, mem);
  }

  private boolean helper(String s, String p, int i, int j, int[][] mem) {
    int lenS = s.length();
    int lenP = p.length();

    if (mem[i][j] != -1) {
      return mem[i][j] == 1;
    }

    if (j == lenP) {
      mem[i][j] = i == lenS ? 1 : 0;
      return mem[i][j] == 1;
    }

    mem[i][j] = 0;
    if (p.charAt(j) == '*') {
      for (int k = i; k < lenS; k++) {
        if (helper(s, p, k, j + 1, mem)) {
          mem[i][j] = 1;
          return mem[i][j] == 1;
        }
      }

      return false;
    } else {
      if (i >= lenS) {
        return mem[i][j] == 1;
      }
      if (!matchChar(s.charAt(i), p.charAt(j))) {
        return mem[i][j] == 1;
      }

      mem[i][j] = helper(s, p, i + 1, j + 1, mem) ? 1 : 0;
      return mem[i][j] == 1;
    }
  }
}
