package com.zil.li.DP;

/**
 * Created by youlongli on 3/11/15.
 *
 * http://www.lintcode.com/en/problem/longest-common-substring/
 */
public class LongestCommonSubstring {
  public int longestCommonSubstring(String A, String B) {
    // write your code here
    int lenA = A.length();
    int lenB = B.length();
    int res = 0;

    for (int i = 0; i < lenA; i++) {
      for (int j = 0; j < lenB; j++) {
        int len = 0;
        while (i + len < lenA && j + len < lenB && A.charAt(i + len) == B.charAt(j + len)) {
          len++;
        }
        res = Math.max(res, len);
      }
    }

    return res;
  }
}
