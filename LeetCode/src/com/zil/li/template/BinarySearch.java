package com.zil.li.template;

/**
 * Created by youlongli on 2/2/15.
 */
public class BinarySearch {
  // This method return the index of the found number, if it does not exist, return the index of lower number
  public int binarySearch(int[] num, int target) {
    int low = 0;
    int high = num.length - 1;

    while (high >= low) {
      int mid = low + (high - low) / 2;
      if (num[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }


    if (num[high] == target) {
      return high;
    } else {
      return high + 1;
    }
  }
}
