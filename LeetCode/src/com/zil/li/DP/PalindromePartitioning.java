package com.zil.li.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 2/26/15.
 *
 * https://oj.leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {
  public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<List<String>>();
    List<String> path = new ArrayList<String>();

    if (s == null) {
      return res;
    }

    boolean[][] isPalindrome = checkPalindrome(s);

    getPartition(res, path, s, 0, isPalindrome);

    return res;
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
          res[i][j] = s.charAt(i) == s.charAt(j) && (l == 2 || res[i + 1][j - 1]);
        }
      }
    }

    return res;
  }

  private void getPartition(List<List<String>> res, List<String> path, String s, int pos, boolean[][] isPalindrome) {
    if (pos == s.length()) {
      res.add(new ArrayList<String>(path));
      return;
    }

    for (int i = pos; i < s.length(); i++) {
      if (!isPalindrome[pos][i]) {
        continue;
      }

      String part = s.substring(pos, i + 1);
      path.add(part);
      getPartition(res, path, s, i + 1, isPalindrome);
      path.remove(path.size() - 1);
    }
  }
}
