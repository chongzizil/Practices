package com.zil.li.array;

import java.util.Arrays;

/**
 * Created by youlongli on 3/7/15.
 *
 * https://oj.leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {
  /**
   * Time complexity: O(n^2) -> Sort takes O(nlogn) and double for loop takes O(n^2)
   */
  public int threeSumClosest(int[] num, int target) {
    if (num == null || num.length < 3) {
      return Integer.MAX_VALUE; // Corner case
    }

    int res = 0;
    int closest = Integer.MAX_VALUE; // The difference for the current res/sum.
    int n = num.length;

    Arrays.sort(num);

    for (int i = 0; i < n - 2; i++) {
      if (i != 0 && num[i] != num[i - 1]) {
        continue; // Skip duplicates
      }

      int l = i + 1;
      int r = n - 1;
      while (l < r) {
        int sum = num[i] + num[l] + num[r];
        if (sum == target) {
          return sum; // Return if find a exact match...
        } else if (sum < target) {
          l++;
          while (l < r && num[l] == num[l - 1]) {
            l++; // Skip duplicates
          }
        } else {
          r--;
          while (l < r && num[r] == num[r + 1]) {
            r--; // Skip duplicates
          }
        }

        // Check if found a closer one.
        if (Math.abs(sum - target) < closest) {
          res = sum;
          closest = Math.abs(sum - target);
        }
      }
    }

    return res;
  }
}
