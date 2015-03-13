package com.zil.li.array;

/**
 * Created by youlongli on 3/10/15.
 *
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    int n = height.length;
    int l = 0;
    int r = n - 1;
    int res = 0;

    while (l < r) {
      int h = Math.min(height[l], height[r]);
      int w = r - l;
      res = Math.max(res, h * w);

      if (height[l] < height[r]) {
        l++;
      } else {
        r--;
      }
    }

    return res;
  }
}
