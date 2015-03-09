package com.zil.li.array;

/**
 * Created by youlongli on 3/7/15.
 *
 * https://oj.leetcode.com/problems/remove-element/
 */
public class RemoveElement {
  public int removeElement(int[] A, int elem) {
    int l = 0;

    for (int i = 0; i < A.length; i++) {
      if (A[i] != elem) {
        A[l] = A[i];
        l++;
      }
    }

    return l;
  }
}
