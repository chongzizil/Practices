package com.zil.li.DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by youlongli on 2/22/15.
 *
 * https://oj.leetcode.com/problems/word-break-ii/
 */
public class WordBreakII {
  /**
   * Idea: First use DP to calculate if the string or part of it exists in the dict. I'll use a two dimension array where dp[i][j] indicates whether s.substring(i, j + 1) exists in the dict or not.
   *
   * Then I use recursive function. Each time I find a left segmentation which exists in the dict, and then I recursively check the right part.
   */
  public List<String> wordBreak(String s, Set<String> dict) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];

    for (int l = 1; l <= n; l++) {
      for (int i = 0; i < n - l + 1; i++) {
        int j = i + l - 1;
        if (dict.contains(s.substring(i, j + 1))) {
          dp[i][j] = true;
        } else {
          dp[i][j] = false;

          for (int k = i; k < j; k++) {
            dp[i][j] = dp[i][j] || (dp[i][k] && dp[k + 1][j]);
          }
        }
      }
    }


    List<List<String>> tmp = helper(s, dict, dp, 0, n - 1);
    List<String> res = new ArrayList<String>();

    for (List<String> list : tmp) {
      if (list.size() > 0) {
        StringBuilder sb = new StringBuilder();
        for (String seg : list) {
          sb.append(seg);
          sb.append(" ");
        }
        sb.setLength(sb.length() - 1);
        res.add(sb.toString());
      }
    }

    return res;
  }

  private List<List<String>> helper(String s, Set<String> dict, boolean[][] dp, int l, int r) {
    List<List<String>> res = new ArrayList<List<String>>();

    if (l > r || !dp[l][r]) {
      res.add(new ArrayList<String>());
      return res;
    }

    for (int i = l; i <= r; i++) {
      // Left part need to be in the dict first, if l < r, then we need to check dp[i + 1][r] to be true
      if (dict.contains(s.substring(l, i + 1)) && (i == r || (i < r && dp[i + 1][r]))) {
        String left = s.substring(l, i + 1);
        List<List<String>> rightAll = helper(s, dict, dp, i + 1, r);
        for (List<String> right : rightAll) {
          List<String> list = new ArrayList<String>();
          list.add(left);
          list.addAll(right);
          res.add(list);
        }
      }
    }

    return res;
  }
}