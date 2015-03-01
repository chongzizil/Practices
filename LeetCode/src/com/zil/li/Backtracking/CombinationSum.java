package com.zil.li.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 2/28/15.
 */
public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();

    if (candidates == null || candidates.length == 0) {
      return res;
    }

    search(res, list, candidates, 0, target, 0);

    return res;
  }

  private void search(List<List<Integer>> res, List<Integer> list, int[] candidates, int sum, int target, int pos) {
    if (sum == target) {
      res.add(new ArrayList<Integer>(list));
      return;
    }

    for (int i = pos; i < candidates.length; i++) {
      if (sum + candidates[i] <= target) {
        list.add(candidates[i]);
        search(res, list, candidates, sum + candidates[i], target, i);
        list.remove(list.size() - 1);
      }
    }
  }
}
