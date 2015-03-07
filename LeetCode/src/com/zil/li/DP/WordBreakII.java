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
    boolean[][] mem = new boolean[n][n]; // mem_ij indicate that s.substring(i, j + 1) can be splitted to 1 or more words existing in the dict.

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

    List<String> res = new ArrayList<String>();
    List<String> list = new ArrayList<String>();

    helper(res, list, dict, mem, s, 0);

    return res;
  }

  private void helper(List<String> res, List<String> list, Set<String> dict, boolean[][] mem, String s, int pos) {
    if (pos == s.length()) {
      res.add(generateStr(list));
      return; // Need return!
    }

    int n = s.length();
    if (!mem[pos][n - 1]) {
      return; // If the rest of the string as whole or splitted parts do not exist in the dict, just return
    }

    for (int i = pos; i < n; i++) {
      if (dict.contains(s.substring(pos, i + 1)) && (i == n - 1 || mem[i + 1][n - 1])) {
        list.add(s.substring(pos, i + 1));
        helper(res, list, dict, mem, s, i + 1);
        list.remove(list.size() - 1);
      }
    }
  }

  private String generateStr(List<String> list) {
    StringBuilder sb = new StringBuilder();
    for (String word : list) {
      sb.append(word);
      sb.append(" ");
    }
    sb.setLength(sb.length() - 1);
    return sb.toString();
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
