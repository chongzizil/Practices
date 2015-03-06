package com.zil.li.binarysearch;

/**
 * Created by youlongli on 2/4/15.
 *
 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinimumInRotatedSortedArrayII {
  /**
   * If there're too many duplicates, the time complexity will be degenerated to O(n).
   */
  public int findMin(int[] num) {
    int l = 0;
    int r = num.length - 1;

    while (l + 1 < r) {
      int mid = l + (r - l) / 2;

      if (num[mid] < num[r]) {
        r = mid;
      } else if (num[mid] > num[r]) {
        l = mid;
      } else {
        r--; // Note: Do not use l++, since we only check the right side.
      }
    }

    return Math.min(num[l], num[r]);
  }
}
