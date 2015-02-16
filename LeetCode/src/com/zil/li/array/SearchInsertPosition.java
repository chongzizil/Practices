package com.zil.li.array;

/**
 * Created by youlongli on 2/9/15.
 */
public class SearchInsertPosition {
  /**
   * Runtime: 221 ms
   */
  public int searchInsert(int[] A, int target) {
    if (A == null || A.length == 0) {
      return 0;
    }

    if (target < A[0]) {
      return 0;
    }

    int l = 0;
    int r = A.length - 1;
    while (l + 1 < r) {
      int mid = l + (r - l) / 2;
      if (A[mid] > target) {
        r = mid;
      } else if (A[mid] < target) {
        l = mid;
      } else {
        return mid;
      }
    }

    // Usually the target is between l and r.
    // Corner cases exist where target is lager or smaller than l and r. (head and tail)
    // target = 1 -> 2, 3, 4
    // target = 9 -> 2, 3, 4
    // The first one is already dealt with at beginning.
    if (A[r] == target) {
      return r;
    }
    if (A[r] < target) {
      return r + 1;
    }
    if (A[l] == target) {
      return l;
    }
    return l + 1;

  }
}
