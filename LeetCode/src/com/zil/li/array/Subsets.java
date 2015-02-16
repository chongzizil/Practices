package com.zil.li.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by youlongli on 1/31/15.
 */
public class Subsets {
  /**
   * Backtracking
   * Time complexity: O(2^n)
   * Space complexity: O(2^n)
   * Runtime: 201 ms
   */
  public List<List<Integer>> solution(int[] nums) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    if (nums == null) {
      return res;
    }

    // Sort the array first to ensure "Elements in a subset must be in non-descending order".
    Arrays.sort(nums);

    subsetsHelper(res, new ArrayList<Integer>(), nums, 0);
    return res;
  }

  public void subsetsHelper(List<List<Integer>> res, List<Integer> list, int[] nums, int pos) {
    res.add(new ArrayList<Integer>(list));
    for (int i = pos; i < nums.length; i++) {
      list.add(nums[i]);
      subsetsHelper(res, list, nums, i + 1);
      list.remove(list.size() - 1);
    }
  }
}
