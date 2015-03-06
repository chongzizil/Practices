package com.zil.li.binarysearch;

/**
 * Created by youlongli on 2/9/15.
 *
 * https://oj.leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {
  /**
   * Runtime: 221 ms
   */
  public int searchInsert(int[] A, int target) {
    if (A == null || A.length == 0) {
      return 0;
    }

    // Two corner case
    if (target < A[0]) {
      return 0;
    } else if (target > A[A.length - 1]) {
      return A.length;
    }

    int l = 0;
    int r = A.length - 1;

    while (l + 1 < r) {
      int mid = l + (r - l) / 2;
      if (A[mid] == target) {
        return mid;
      }

      if (A[mid] > target) {
        r = mid;
      } else {
        l = mid;
      }
    }

    // A[l] must be smaller than target and A[r] must be larger than target
    // Note: We need to deal with corner case: target is larger or smaller than all elements at the start
    if (A[l] == target) {
      return l;
    }

    return l + 1;
  }
}
