package com.zil.li.array;

/**
 * Created by youlongli on 2/3/15.
 */
public class MedianOfTwoSortedArrays {
  /**
   * The idea is to know how to find Kth smallest number in two sorted array. If the total length of two array is odd,
   * just find the middle one is enough, otherwise we need to find the kth and (k + 1)th number and divide them by 2.
   * Runtime: 414 ms
   */
  public double findMedianSortedArrays(int A[], int B[]) {
    if (A == null || B == null) {
      return 0.0;
    }

    double res = 0.0;
    int totalLength = A.length + B.length;

    if (totalLength % 2 ==0) {
      res = (double)(findKth(A, 0, B, 0, totalLength / 2) + findKth(A, 0, B, 0, totalLength / 2 + 1)) / 2.0;
    } else {
      res = (double)(findKth(A, 0, B, 0, totalLength / 2 + 1));
    }

    return res;
  }

  /**
   * The idea is each time we try to find the (k / 2)th number keyA and keyB from both array. If keyA < keyB, then all
   * numbers before the index of (k / 2) in A can be discarded and vice versa.
   */
  private int findKth(int[] A, int indexA, int[] B, int indexB, int k) {
    // Corner case
    if (indexA >= A.length) {
      return B[indexB + k - 1];
    } else if (indexB >= B.length) {
      return A[indexA + k - 1];
    }

    // Base case
    if (k == 1) {
      return Math.min(A[indexA], B[indexB]);
    }

    // Minus 1 because the index is zero based.
    int mid = k / 2 - 1;
    // We discard (k / 2) numbers
    int newK = k - k / 2;

    // Find the (k / 2)th number from both array. If (index + mid) >= length, then set it to +INF/Integer.MAX_VALUE.
    int keyA = indexA + mid >= A.length ? Integer.MAX_VALUE : A[indexA + mid];
    int keyB = indexB + mid >= B.length ? Integer.MAX_VALUE : B[indexB + mid];

    if (keyA < keyB) {
      return findKth(A, indexA + mid + 1, B, indexB, newK);
    } else {
      return findKth(A, indexA, B, indexB + mid + 1, newK);
    }
  }
}
