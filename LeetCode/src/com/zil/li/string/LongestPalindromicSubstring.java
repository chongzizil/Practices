package com.zil.li.string;

/**
 * Created by youlongli on 1/28/15.
 *
 * https://oj.leetcode.com/problems/longest-palindromic-substring/
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

    return hasPalindrome ? s.substring(l + 1, r) : "";
  }

  /**
   * This is a dp solution. The idea is if a string is palindrome, and the characters on both sides
   * are identical, then the expanded string is also a palindrome.
   * Time complexity: O(n^2)
   * Space complexity: O(n^2)
   * Runtime: 361 ms
   */
  public String longestPalindrome(String s) {
    if (s == null) {
      return null;
    }

    int n = s.length();
    boolean[][] dp = new boolean[n][n];

    for (int l = 1; l <= n; l++) {
      for (int i = 0; i < n - l + 1; i++) {
        int j = i + l - 1;
        if (l == 1) {
          dp[i][j] = true;
        } else {
          dp[i][j] = s.charAt(i) == s.charAt(j) && (l == 2 || dp[i + 1][j - 1]);
        }
      }
    }

    // Start from the longest length...
    for (int l = n; l >= 1; l--) {
      for (int i = 0; i < n - l + 1; i++) {
        int j = i + l - 1;
        if (dp[i][j]) {
          return s.substring(i, j + 1);
        }
      }
    }

    throw new IllegalArgumentException("No way...");
  }
}
