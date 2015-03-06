package com.zil.li.binarysearch;

/**
 * Created by youlongli on 2/3/15.
 *
 * https://oj.leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {
  /**
   * The idea is to know how to find Kth smallest number in two sorted array. If the total length of two array is odd,
   * just find the middle one is enough, otherwise we need to find the kth and (k + 1)th number and divide them by 2.
   * Runtime: 414 ms
   */
  public double findMedianSortedArrays(int[] A, int[] B) {
    int len = A.length + B.length;
    double res = 0;

    if (len % 2 == 0) {
      res = (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
    } else {
      res = findKth(A, 0, B, 0, len / 2 + 1);
    }

    return res;
  }

  // Return double
  private double findKth(int[] A, int indexA, int[] B, int indexB, int k) {
    int lenA = A.length;
    int lenB = B.length;

    // Base case
    if (indexA >= lenA) {
      return B[indexB + k - 1];
    } else if (indexB >= lenB) {
      return A[indexA + k - 1];
    }
    // Base case, watch the order, first check the index!
    if (k == 1) {
      return Math.min(A[indexA], B[indexB]);
    }

    // Note: K is 1 based.
    int keyA = indexA + k / 2 - 1 >= lenA ? Integer.MAX_VALUE : A[indexA + k / 2 - 1];
    int keyB = indexB + k / 2 - 1 >= lenB ? Integer.MAX_VALUE : B[indexB + k / 2 - 1];

    if (keyA < keyB) {
      return findKth(A, indexA + k / 2, B, indexB, k - k / 2);
    } else {
      return findKth(A, indexA, B, indexB + k / 2, k - k / 2);
    }
  }
}
