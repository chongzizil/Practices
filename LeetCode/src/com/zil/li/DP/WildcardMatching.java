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
          return true; // Remember to check
        }

        back = true;
        memI = i;
        memJ = j;
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
}
