package com.zil.li.array;

/**
 * Created by youlongli on 3/10/15.
 *
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
  public int trap(int[] A) {
    int n = A.length;
    int l = 0;
    int r = n - 1;
    int currLevel = 0;

    int totalUnit = 0;
    int blockUnit = 0;

    while (l <= r) {
      int minLevel = Math.min(A[l], A[r]);
      if (minLevel > currLevel) {
        totalUnit += (r - l + 1) * (minLevel - currLevel);
        currLevel = minLevel;
      }

      if (A[l] < A[r]) {
        blockUnit += A[l++];
      } else {
        blockUnit += A[r--];
      }
    }

    return totalUnit - blockUnit;
  }
}
