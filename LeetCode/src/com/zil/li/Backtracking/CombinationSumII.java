package com.zil.li.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by youlongli on 2/28/15.
 *
 * https://oj.leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumII {
  public List<List<Integer>> combinationSum2(int[] num, int target) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();

    if (num == null || num.length == 0) {
      return res;
    }

    Arrays.sort(num);

    search(res, list, num, 0, target, 0);

    return res;
  }

  private void search(List<List<Integer>> res, List<Integer> list, int[] num, int sum, int target, int pos) {
    if (sum == target) {
      res.add(new ArrayList<Integer>(list));
    }

    for (int i = pos; i < num.length; i++) {
      if (i != pos && num[i] == num[i - 1]) {
        continue;
      }
      if (sum + num[i] <= target) {
        list.add(num[i]);
        search(res, list, num, sum + num[i], target, i + 1);
        list.remove(list.size() - 1);
      }
    }
  }
}
