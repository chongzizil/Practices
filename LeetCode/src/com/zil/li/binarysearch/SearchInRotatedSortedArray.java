package com.zil.li.binarysearch;

/**
 * Created by youlongli on 2/2/15.
 *
 * https://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {
  /**
   * Using the template...
   * Runtime: 237 ms
   */
  public int solutionA(int[] A, int target) {
    int l = 0;
    int r = A.length - 1;

    while (l + 1 < r) {
      int mid = l + (r - l) / 2;

      if (A[mid] == target) {
        return mid;
      }

      if (A[mid] < A[r]) { // Right is sorted
        if (A[mid] <= target && target <= A[r]) {
          l = mid;
        } else {
          r = mid;
        }
      } else { // Right is not sorted
        if (A[l] <= target && target <= A[mid]) {
          r = mid;
        } else {
          l = mid;
        }
      }
    }

    if (A[l] == target) {
      return l;
    } else if (A[r] == target) {
      return r;
    }

    return - 1;
  }

  /**
   * The idea is to check whether the rotation point is at the right or left first.
   * Say if the left part is sorted, then if the target does not exist in it, it may well likely exist in the right part. Unlike normal binary sort, we need to check the other side.
   * Runtime: 197 ms
   */
  public int solutionB(int[] A, int target) {
    int low = 0;
    int high = A.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (target == A[mid]) {
        return mid;
      }

      if (A[low] <= A[mid]) {
        if (A[low] <= target && target <= A[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else {
        if (A[mid] <= target && target <= A[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }

    return -1;
  }
}
