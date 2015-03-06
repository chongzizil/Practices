package com.zil.li.binarysearch;

/**
 * Created by youlongli on 2/4/15.
 *
 * https://oj.leetcode.com/problems/find-peak-element/
 */
public class FindPeakElement {
  public int findPeakElement(int[] num) {
    if (num == null || num.length == 0) {
      return 0;
    }

    int l = 0;
    int r = num.length - 1;

    while (l + 1 < r) {
      // Assume there're at least 3 elements, so prev and post will be valid index.
      int mid = l + (r - l) / 2;
      int prev = mid - 1;
      int post = mid + 1;

      if (num[prev] < num[mid] && num[mid] < num[post]) { // Increasing
        l = mid;
      } else if (num[prev] > num[mid] && num[mid] > num[post]) { // Decreasing
        r = mid;
      } else if (num[prev] > num[mid] && num[mid] < num[post]) { // Bottom
        r = mid;
      } else if (num[prev] < num[mid] && num[mid] > num[post]) { // Peek
        return mid;
      }
    }

    return num[l] > num[r] ? l : r;
  }
}
