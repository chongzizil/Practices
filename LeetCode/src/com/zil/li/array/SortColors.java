package com.zil.li.array;

/**
 * Created by youlongli on 3/8/15.
 *
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public void solutionA(int[] A) {
    int m = 0;
    int n = 0;

    for (int i = 0; i < A.length; i++) {
      if (A[i] == 0) {
        m++;
        n++;
      } else if (A[i] == 1) {
        n++;
      }
    }

    for (int i = 0; i < m; i++) {
      A[i] = 0;
    }

    for (int i = m; i < n; i++) {
      A[i] = 1;
    }

    for (int i = n; i < A.length; i++) {
      A[i] = 2;
    }
  }

  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public void solutionB(int[] A) {
    int[] count = new int[3];

    for (int i = 0; i < A.length; i++) {
      count[A[i]]++;
    }

    int beg = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < count[i]; j++) {
        A[beg++] = i;
      }
    }
  }
}
