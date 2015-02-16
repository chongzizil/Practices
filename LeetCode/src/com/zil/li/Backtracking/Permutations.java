package com.zil.li.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 2/1/15.
 */
public class Permutations {
  /**
   * Backtracking.
   * Use a list to store the integers yet to be added.
   * Runtime: 236 ms
   */
  public List<List<Integer>> solution(int[] num) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();

    if (num == null || num.length == 0) {
      return res;
    }

    permuteHelper(res, list, num);
    return res;
  }

  public void permuteHelper(List<List<Integer>> res, List<Integer> list, int[] num) {
    if (list.size() == num.length) {
      res.add(new ArrayList<Integer>(list));
    }

    for (int i = 0; i < num.length; i++) {
      if (list.contains(num[i])) {
        continue;
      }
      list.add(num[i]);
      permuteHelper(res, list, num);
      list.remove(list.size() - 1);
    }
  }
}
