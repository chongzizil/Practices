package com.zil.li.array;

/**
 * Created by youlongli on 3/8/15.
 *
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {
  /**
   * One pass solution.
   * Idea: use two pointers as delimiter
   * If elem is 0, swap it and move index and left pointer. ()
   * If elem is 1, just update index since such an elem will be swap to the right place later
   * If elem is 2,
   *
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public void sortColors(int[] A) {
    int i = 0;
    int l = 0;
    int r = A.length - 1;

    while (i <= r) {
      if (A[i] == 0) {
        swap(A, i, l);
        i++;
        l++;
      } else if (A[i] == 1) {
        i++;
      } else {
        swap(A, i, r);
        r--;
      }
    }
  }

  private void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
  }

  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public void solutionB(int[] A) {
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
  public void solutionA(int[] A) {
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
