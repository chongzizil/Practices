package com.zil.li.array;

/**
 * Created by youlongli on 3/10/15.
 *
 * https://leetcode.com/problems/first-missing-positive/
 *
 * Ref: http://www.cnblogs.com/yuzhangcmu/p/4200096.html
 */
public class FirstMissingPositive {
  public int firstMissingPositive(int[] A) {
    int n = A.length;

    for (int i = 0; i < n; i++) {
      // A[i] is positive and in the range (0, n]
      // Two elements need to be different before swap
      while (A[i] > 0 && A[i] <= n && A[i] != i + 1 && A[i] != A[A[i] - 1]) {
        swap(A, i, A[i] - 1);
      }
    }

    for (int i = 0; i < n; i++) {
      if (A[i] != i + 1) {
        return i + 1;
      }
    }

    return n + 1;
  }

  private void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
  }
}
