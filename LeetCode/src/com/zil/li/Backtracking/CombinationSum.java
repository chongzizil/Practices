package com.zil.li.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by youlongli on 2/28/15.
 */
public class CombinationSum {
  /**
   * More concise solution.
   */
  public List<List<Integer>> solutionA(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();

    if (candidates == null) {
      return res;
    }

    Arrays.sort(candidates);

    searchA(res, list, candidates, target, 0);

    return res;
  }

  private void searchA(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int pos) {
    if (target == 0) {
      res.add(new ArrayList<Integer>(list));
      return;
    }

    for (int i = pos; i < candidates.length; i++) {
      if (candidates[i] <= target) {
        list.add(candidates[i]);
        searchA(res, list, candidates, target - candidates[i], i);
        list.remove(list.size() - 1);
      }
    }
  }

  /**
   * Solution
   */
  public List<List<Integer>> solutionB(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();

    if (candidates == null || candidates.length == 0) {
      return res;
    }

    Arrays.sort(candidates);

    searchB(res, list, candidates, 0, target, 0);

    return res;
  }

  private void searchB(List<List<Integer>> res, List<Integer> list, int[] candidates, int sum, int target, int pos) {
    if (sum == target) {
      res.add(new ArrayList<Integer>(list));
      return;
    }

    for (int i = pos; i < candidates.length; i++) {
      if (sum + candidates[i] <= target) {
        list.add(candidates[i]);
        searchB(res, list, candidates, sum + candidates[i], target, i);
        list.remove(list.size() - 1);
      }
    }
  }
}
