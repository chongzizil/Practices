package com.zil.li.binarysearch;

/**
 * Created by youlongli on 2/3/15.
 *
 * https://oj.leetcode.com/problems/search-for-a-range/
 */
public class SearchForARange {
  public int[] searchRange(int[] A, int target) {
    int[] res = new int[]{-1, -1};
    int n = A.length;

    int l = 0;
    int r = n - 1;
    // Find left bound
    // There should be two elements for us to decide for the left bound. (Might be one...)
    while (l + 1 < r) {
      int mid = l + (r - l) / 2;

      if (A[mid] > target) {
        r = mid;
      } else if (A[mid] < target) {
        l = mid;
      } else {
        // Keep searching the left bound
        r = mid;
      }
    }

    if (A[l] == target) {
      res[0] = l;
    } else if (A[r] == target) {
      res[0] = r;
    } else {
      return res;
    }

    l = 0;
    r = n - 1;
    // Find right bound
    while (l + 1 < r) {
      int mid = l + (r - l) / 2;

      if (A[mid] > target) {
        r = mid;
      } else if (A[mid] < target) {
        l = mid;
      } else {
        l = mid;
      }
    }

    if (A[r] == target) {
      res[1] = r;
    } else if (A[l] == target) {
      res[1] = l;
    }

    return res;
  }
}
