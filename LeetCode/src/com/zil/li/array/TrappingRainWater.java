package com.zil.li.array;

/**
 * Created by youlongli on 3/10/15.
 *
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
  public int trap(int[] A) {
    int l = 0;
    int r = A.length - 1;
    int area = 0;
    int block = 0;
    int currLevel = 0;

    while (l <= r) {
      int min = Math.min(A[l], A[r]);
      if (min > currLevel) {
        area += (min - currLevel) * (r - l + 1);
        currLevel = min;
      }

      if (A[l] < A[r]) {
        block += A[l++];
      } else {
        block += A[r--];
      }
    }

    return area - block;
  }
}
