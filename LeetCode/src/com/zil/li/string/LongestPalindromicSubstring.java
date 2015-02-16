package com.zil.li.string;

/**
 * Created by youlongli on 1/28/15.
 */
public class LongestPalindromicSubstring {
  /**
   * The idea is each palindrome starts from its center, which is one or two identical
   * characters. So by checking all the centers (2n - 1) and expands them to find the
   * result is much faster.
   * Time complexity: O(n^2)
   * Space complexity: O(1)
   * Runtime: 255 ms
   */
  public String solutionA(String s) {
    String res = "";
    String tmp = "";
    for (int i = 0; i < s.length(); i++) {
      // The center is a single character
      tmp = getPalindrome(s, i, i);
      res = res.length() > tmp.length() ? res : tmp;
      // The center is two character
      tmp = getPalindrome(s, i, i + 1);
      res = res.length() > tmp.length() ? res : tmp;
    }

    return res;
  }


  public String getPalindrome(String s, int l, int r) {
    boolean hasPalindrome = false;
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      hasPalindrome = true;
      l--;
      r++;
    }
    if (hasPalindrome) {
      return s.substring(l + 1, r);
    } else {
      return "";
    }
  }

  /**
   * This is a dp solution. The idea is if a string is palindrome, and the characters on both sides
   * are identical, then the expanded string is also a palindrome.
   * Time complexity: O(n^2)
   * Space complexity: O(n^2)
   * Runtime: 396 ms
   */
  public String longestPalindrome(String s) {
    int n = s.length();

    int start = 0;
    int end = 0;
    int max = 0;
    boolean[][] dp = new boolean[n][n];

    for (int l = 0; l < n; l++) {
      for (int i = 0; i < n - l; i++) {
        int j = i + l;
        if (i == j) {
          dp[i][j] = true;
        } else {
          if (s.charAt(i) == s.charAt(j)) {
            if (l == 1) {
              dp[i][j] = true;
            } else if (dp[i + 1][j - 1]) {
              dp[i][j] = true;
            } else {
              dp[i][j] = false;
            }
          } else {
            dp[i][j] = false;
          }
        }
      }
    }

    for (int l = 0; l < n; l++) {
      for (int i = 0; i < n - l; i++) {
        int j = i + l;
        if (dp[i][j] && j - i > max) {
          start = i;
          end = j;
        }
      }
    }

    return s.substring(start, end + 1);
  }
}
