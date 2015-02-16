package com.zil.li.array;

/**
 * Created by youlongli on 2/4/15.
 */
public class FindPeakElement {
  public int findPeakElement(int[] num) {
    if (num == null || num.length == 0) {
      return 0;
    }

    int l = 0;
    int r = num.length - 1;

    while (l < r - 1) {
      int mid = l + (r - l) / 2;
      int prev = num[mid - 1];
      int next = num[mid + 1];

      if (num[mid] > prev && num[mid] > next) {
        return mid;
      }

      if (num[mid] > prev && num[mid] < next) {
        // increasing
        l = mid;
      } else if (num[mid] < prev && num[mid] > next) {
        // decreasing
        r = mid;
      } else {
        // bottom...
        r = mid;
      }
    }

    return num[l] > num[r] ? l : r;
  }
}
