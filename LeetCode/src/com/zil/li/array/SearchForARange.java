package com.zil.li.array;

/**
 * Created by youlongli on 2/3/15.
 */
public class SearchForARange {
  public int[] searchRange(int[] A, int target) {
    int[] res = new int[]{-1, -1};

    if (A == null || A.length == 0) {
      return res;
    }

    int low = 0;
    int high = A.length - 1;

    // Left bound
    // There should be two elements for us to decide for the left bound. (Might be one...)
    while (low < high - 1) {
      int mid = low + (high - low) / 2;

      if (A[mid] > target) {
        high = mid - 1;
      } else if (A[mid] < target) {
        low = mid + 1;
      } else {
        // Keep searching the left bound
        high = mid;
      }
    }

    if (A[low] == target) {
      res[0] = low;
    } else if (A[high] == target) {
      res[0] = high;
    } else {
      return res;
    }

    low = 0;
    high = A.length - 1;

    // Right bound
    while (low < high - 1) {
      int mid = low + (high - low) / 2;

      if (A[mid] > target) {
        high = mid - 1;
      } else if (A[mid] < target) {
        low = mid + 1;
      } else {
        low = mid;
      }
    }

    if (A[high] == target) {
      res[1] = high;
    } else if (A[low] == target) {
      res[1] = low;
    } else {
      return res;
    }

    return res;
  }
}
