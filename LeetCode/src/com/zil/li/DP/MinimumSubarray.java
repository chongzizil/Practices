package com.zil.li.DP;

import java.util.ArrayList;

/**
 * Created by youlongli on 3/14/15.
 *
 * http://lintcode.com/en/problem/minimum-subarray/
 *
 * Idea1: Multiply every elem by -1 which transfer this problem to maximum subarray, return the negative result at last.
 * Idea2: Same as maximum subarray, just keep a variable min which is less or equal to 0
 */
public class MinimumSubarray {
  public int solutionA(ArrayList<Integer> nums) {
    // write your code
    int res = Integer.MAX_VALUE;
    int min = 0;

    for (int num : nums) {
      min += num;
      res = Math.min(res, min);
      min = Math.min(0, min);
    }

    return res;
  }

  public int solutionB(ArrayList<Integer> nums) {
    int res = Integer.MIN_VALUE;
    int max = 0;

    for (int num : nums) {
      max += -num;
      res = Math.max(res, max);
      max = Math.max(0, max);
    }

    return -res;
  }
}
