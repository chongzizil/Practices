package com.zil.li.array;

/**
 * Created by youlongli on 3/7/15.
 *
 * https://oj.leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {
  public void merge(int A[], int m, int B[], int n) {
    while (m > 0 && n > 0) {
      if (A[m - 1] > B[n - 1]) {
        A[m + n - 1] = A[m - 1];
        m--;
      } else {
        A[m + n - 1] = B[n - 1];
        n--;
      }
    }

    while (n > 0) {
      A[n - 1] = B[n - 1];
      n--;
    }
  }
}
