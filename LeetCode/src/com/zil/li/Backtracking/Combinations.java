package com.zil.li.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 3/2/15.
 *
 * https://oj.leetcode.com/problems/combinations/
 */
public class Combinations {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();

    helper(res, list, n, k, 1);

    return res;
  }

  private void helper(List<List<Integer>> res, List<Integer> list, int n, int k, int pos) {
    if (list.size() == k) {
      res.add(new ArrayList<Integer>(list));
      return;
    }

    for (int i = pos; i <= n; i++) {
      list.add(i);
      helper(res, list, n, k, i + 1);
      list.remove(list.size() - 1);
    }
  }
}
