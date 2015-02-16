package com.zil.li.array;

/**
 * Created by youlongli on 2/2/15.
 */
public class SearchInRotatedSortedArrayII {
  /**
   * Using the template...
   * Runtime: 231 ms
   */
  public boolean search(int[] A, int target) {
    int l = 0;
    int r = A.length - 1;

    while (l + 1 < r) {
      int mid = l + (r - l) / 2;

      if (target == A[mid]) {
        return true;
      }

      if (A[l] < A[mid]) { // Left is sorted
        if (A[l] <= target && target <= A[mid]) {
          r = mid;
        } else {
          l = mid;
        }
      } else if (A[l] > A[mid]) { // Right is sorted
        if (A[mid] <= target && target <= A[r]) {
          l = mid;
        } else {
          r = mid;
        }
      } else if (A[l] == A[mid]) {
        l++;
      }
    }

    if (A[l] == target || A[r] == target) {
      return true;
    }

    return false;
  }
  /**
   * The main problem is when A[low] = A[mid], there's no way to tell whether numbers from low to mid are ascending...
   * Say low = 0 and mid = 3 e.g. 1). 1211  2:11112111
   * Hench we need to check step by step in that case, which might result in a O(n) time complexity if there're a lot of duplicate numbers.
   * Time complexity: O(n) (Worst case...)
   * Space complexity: O(1)
   * Runtime: 221 ms
   */
  public boolean solutionB(int[] A, int target) {
    int low = 0;
    int high = A.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (target == A[mid]) {
        return true;
      }

      if (A[low] < A[mid]) {
        if (A[low] <= target && target < A[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else if (A[low] > A[mid]) {
        if (A[mid] < target && target <= A[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      } else {
        // No way to tell if the numbers are ascending, just skip one to see....
        low++;
      }
    }

    return false;
  }
}
