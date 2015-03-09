package com.zil.li.array;

/**
 * Created by youlongli on 3/7/15.
 *
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicatesFromSortedArrayII {
  public int removeDuplicates(int[] A) {
    int n = A.length;
    if (n < 3) {
      return n;
    }

    int i = 1;
    for (int j = 2; j < n; j++) {
      if (A[j] != A[i - 1]) {
        i++;
        A[i] = A[j];
      }
    }

    return i + 1;
  }
}
