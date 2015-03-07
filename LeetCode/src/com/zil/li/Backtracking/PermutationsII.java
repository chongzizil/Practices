package com.zil.li.Backtracking;

import java.util.*;

/**
 * Created by youlongli on 2/1/15.
 *
 * https://oj.leetcode.com/problems/permutations-ii/
 */
public class PermutationsII {
  /**
   * Backtracking.
   * Use a map to check if the integer is already taken.
   * Runtime: 236 ms
   */
  public List<List<Integer>> solution(int[] num) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();
    boolean[] visited = new boolean[num.length];

    if (num == null || num.length == 0) {
      return res;
    }

    Arrays.sort(num);
    permuteHelper(res, list, visited, num);
    return res;
  }

  public void permuteHelper(List<List<Integer>> res, List<Integer> list, boolean[] visited, int[] num) {
    if (list.size() == num.length) {
      res.add(new ArrayList<Integer>(list));
    }

    for (int i = 0; i < num.length; i++) {
      if (visited[i] || (i != 0 && num[i] == num[i - 1] && !visited[i - 1])) {
        continue;
      }

      list.add(num[i]);
      visited[i] = true;
      permuteHelper(res, list, visited, num);
      visited[i] = false;
      list.remove(list.size() - 1);
    }
  }
}
