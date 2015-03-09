package com.zil.li.array;

import java.util.Arrays;

/**
 * Created by youlongli on 3/7/15.
 *
 * https://oj.leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {
  public int threeSumClosest(int[] num, int target) {
    if (num == null || num.length < 3) {
      return Integer.MAX_VALUE;
    }

    int res = Integer.MAX_VALUE; // Integer.MAX_VALUE indicates invalid result
    int closest = Integer.MAX_VALUE; // The difference for the current res.
    int n = num.length;
    Arrays.sort(num);

    for (int i = 0; i < n - 2; i++) {
      int l = i + 1;
      int r = n - 1;
      while (l < r) {
        int sum = num[i] + num[l] + num[r];
        if (sum == target) {
          return sum;
        } else if (sum < target) {
          l++;
        } else {
          r--;
        }
        if (Math.abs(sum - target) < closest) {
          res = sum;
          closest = Math.abs(sum - target);
        }
      }
    }

    return res;
  }
}
