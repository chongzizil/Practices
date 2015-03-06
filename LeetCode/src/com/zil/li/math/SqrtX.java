package com.zil.li.math;

/**
 * Created by youlongli on 2/3/15.
 *
 * https://oj.leetcode.com/problems/sqrtx/
 */
public class SqrtX {
  /**
   * Use binary search
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public int solutionA(int x) {
    if (x <= 1) {
      return x; // Base case
    }

    int l = 1;
    int r = x;

    while (l + 1 < r) {
      int mid = l + (r - l) / 2;
      int tmp = x / mid;

      if (tmp > mid) {
        l = mid;
      } else if (tmp < mid) {
        r = mid;
      } else {
        return mid;
      }
    }

    return l;
  }

  public int solutionB(int x) {
    long low = 0;
    long high = x;

    while (low <= high) {
      long mid = low + (high - low) / 2;
//      long mid = (low + high) >>> 1;
      if (mid * mid > x) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return (int)high;
  }
}
