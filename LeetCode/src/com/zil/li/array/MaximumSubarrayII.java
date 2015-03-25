package com.zil.li.array;

import java.util.ArrayList;

/**
 * Created by youlongli on 3/14/15.
 *
 * http://lintcode.com/en/problem/maximum-subarray-ii/
 */
public class MaximumSubarrayII {
  public int maxTwoSubArrays(ArrayList<Integer> nums) {
    int n = nums.size();
    int max = 0;
    int[] left = new int[n];
    int[] right = new int[n];

    max = Math.max(nums.get(0), 0);
    left[0] = nums.get(0);
    for (int i = 1; i < n; i++) {
      max += nums.get(i);
      left[i] = Math.max(left[i - 1], max);
      max = Math.max(max, 0);
    }

    max = Math.max(nums.get(n - 1), 0);
    right[n - 1] = nums.get(n - 1);
    for (int i = n - 2; i >= 0; i--) {
      max += nums.get(i);
      right[i] = Math.max(right[i + 1], max);
      max = Math.max(max, 0);
    }

    // Note 1: since maximum result maybe smaller than 0, initialize res to -oo
    // Note 2: Two subarray does not overlap! So we check left[i] + right[i + 1]
    int res = Integer.MIN_VALUE;
    for (int i = 0; i < n - 1; i++) {
      res = Math.max(res, left[i] + right[i + 1]);
    }

    return res;
  }
}
