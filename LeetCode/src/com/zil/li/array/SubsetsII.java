package com.zil.li.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by youlongli on 2/1/15.
 */
public class SubsetsII {
  /**
   * Backtracking
   * Time complexity: O(2^n) (Worst case)
   * Space complexity: O(2^n)
   * Runtime: 230 ms
   */
  public List<List<Integer>> solution(int[] num) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    if (num == null) {
      return res;
    }

    // Sort the array first to ensure "Elements in a subset must be in non-descending order".
    Arrays.sort(num);

    subsetsWithDupHelper(res, new ArrayList<Integer>(), num, 0);
    return res;
  }

  public void subsetsWithDupHelper(List<List<Integer>> res, List<Integer> list, int[] num, int pos) {
    res.add(new ArrayList<Integer>(list));
    for (int i = pos; i < num.length; i++) {
      if (i != pos && num[i] == num[i - 1]) {
        continue;
      }
      list.add(num[i]);
      subsetsWithDupHelper(res, list, num, i + 1);
      list.remove(list.size() - 1);
    }
  }
}
