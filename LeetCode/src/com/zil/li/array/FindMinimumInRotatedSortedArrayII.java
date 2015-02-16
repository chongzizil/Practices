package com.zil.li.array;

/**
 * Created by youlongli on 2/4/15.
 */
public class FindMinimumInRotatedSortedArrayII {
  public int findMin(int[] num) {
    if (num == null || num.length == 0) {
      return 0;
    }

    int l = 0;
    int r = num.length - 1;

    while (l < r - 1) {
      int mid = l + (r - l) / 2;

      if (num[mid] < num[r]) {
        r = mid;
      } else if (num[mid] == num[r]) {
        r--;
      } else if (num[mid] > num[l]) {
        l = mid;
      } else {
        l++;
      }
    }

    return Math.min(num[l], num[r]);
  }
}
