package com.zil.li.array;

/**
 * Created by youlongli on 3/7/15.
 *
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {
  // Compare i - 1 and j
  public int removeDuplicatesA(int[] A) {
    if (A.length < 2) {
      return A.length;
    }

    int i = 1;

    for (int j = 1; j < A.length; j++) {
      if (A[i - 1] != A[j]) {
        A[i++] = A[j];
      }
    }

    return i;
  }

  // Compare j and j - 1
  public int removeDuplicatesB(int[] A) {
    int n = A.length;
    if (n < 2) {
      return n;
    }

    int i = 0;
    for (int j = 1; j < A.length; j++) {
      if (A[j] != A[j - 1]) {
        i++;
        A[i] = A[j];
      }
    }

    return i + 1;
  }
}
