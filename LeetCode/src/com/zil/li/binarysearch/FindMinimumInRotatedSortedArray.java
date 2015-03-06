package com.zil.li.binarysearch;

/**
 * Created by youlongli on 2/4/15.
 */
public class FindMinimumInRotatedSortedArray {
  /**
   * The idea: always discards numbers on the right side first and keep the left if possible.
   * If there's only two numbers left, then the smallest one is the answer.
   * Runtime: 196 ms
   */
  public int findMin(int[] num) {
    if (num == null || num.length == 0) {
      return 0;
    }

    int l = 0;
    int r = num.length - 1;

    while (l < r - 1) {
      int mid = l + (r - l) / 2;

      // Remember, first discard the right if possible. Otherwise if the array is not rotated, it will cause bug...
      if (num[mid] < num[r]) {
        r = mid;
      } else {
        l = mid;
      }
    }

    // Except for the case where the array is not rotated, the left element should be the largest and the right should be smallest.
    return Math.min(num[l], num[r]);
  }
}
