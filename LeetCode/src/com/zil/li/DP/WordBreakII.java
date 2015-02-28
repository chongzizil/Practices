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
  public List<String> solutionA(String s, Set<String> dict) {
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

    List<List<String>> tmp = getWords(s, dict, dp, 0, n - 1);
    List<String> res = new ArrayList<String>();

    for (List<String> list : tmp) {
      if (list.size() > 0) {
        StringBuilder sb = new StringBuilder();
        for (String word : list) {
          sb.append(word);
          sb.append(" ");
        }

        sb.setLength(sb.length() - 1);
        res.add(sb.toString());
      }
    }

    return res;
  }

  public List<List<String>> getWords(String s, Set<String> dict, boolean[][] dp, int l, int r) {
    List<List<String>> res = new ArrayList<List<String>>();
    if (l > r || !dp[l][r]) {
      res.add(new ArrayList<String>());
      return res;
    }

    for (int i = l; i <= r; i++) {
      if (dict.contains(s.substring(l, i + 1)) && (i == r || i < r && dp[i + 1][r])) {
        String leftWord = s.substring(l, i + 1);
        List<List<String>> rightWordLists = getWords(s, dict, dp, i + 1, r);
        for (List<String> rightWords : rightWordLists) {
          List<String> list = new ArrayList<String>();
          list.add(leftWord);
          list.addAll(rightWords);
          res.add(list);
        }
      }
    }

    return res;
  }

  /**
   * Backtracking solution
   */
  public List<String> solutionB(String s, Set<String> dict) {
    int n = s.length();

    boolean[][] mem = new boolean[n][n];

    for (int l = 1; l <= n; l++) {
      for (int i = 0; i < n - l + 1; i++) {
        int j = i + l - 1;
        if (dict.contains(s.substring(i, j + 1))) {
          mem[i][j] = true;
        } else {
          mem[i][j] = false;
          for (int k = i; k < j; k++) {
            mem[i][j] = mem[i][j] || (mem[i][k] && mem[k + 1][j]);
          }
        }
      }
    }

    List<List<String>> tmp = new ArrayList<List<String>>();
    List<String> list = new ArrayList<String>();
    List<String> res = new ArrayList<String>();
    helperB(tmp, list, s, dict, mem, 0);

    for (List<String> tmpList : tmp) {
      if (tmpList.size() > 0) {
        StringBuilder sb = new StringBuilder();
        for (String word : tmpList) {
          sb.append(word);
          sb.append(" ");
        }
        sb.setLength(sb.length() - 1);
        res.add(sb.toString());
      }
    }

    return res;
  }

  private void helperB(List<List<String>> res, List<String> list, String s, Set<String> dict, boolean[][] mem, int beg) {
    if (beg >= s.length()) {
      res.add(new ArrayList<String>(list));
      return;
    }

    int n = s.length();
    if (!mem[beg][n - 1]) {
      return;
    }

    for (int i = beg; i < n; i++) {
      if (dict.contains(s.substring(beg, i + 1)) && (i == n - 1 || mem[i + 1][n - 1])) {
        list.add(s.substring(beg, i + 1));
        helperB(res, list, s, dict, mem, i + 1);
        list.remove(list.size() - 1);
      }
    }
  }
}
