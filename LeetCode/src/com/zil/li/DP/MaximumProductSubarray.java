package com.zil.li.DP;

/**
 * Created by youlongli on 2/22/15.
 *
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {
  public int maxProduct(int[] A) {
    if (A == null) {
      return 0;
    }

    int n = A.length;
    int[] max = new int[n];
    int[] min = new int[n];

    max[0] = A[0];
    min[0] = A[0];

    for (int i = 1; i < n; i++) {
      max[i] = Math.max(A[i], Math.max(max[i - 1] * A[i], min[i - 1] * A[i]));
      min[i] = Math.min(A[i], Math.min(max[i - 1] * A[i], min[i - 1] * A[i]));
    }

    int res = max[0];
    for (int i = 1; i < n; i++) {
      res = Math.max(res, max[i]);
    }

    return res;
  }
}
