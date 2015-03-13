package com.zil.li.array;

/**
 * Created by youlongli on 3/10/15.
 *
 * https://leetcode.com/problems/rotate-image/
 */
public class RotateImage {
  public void rotate(int[][] matrix) {
    int n = matrix.length;

    for (int k = 0; k < n / 2; k++) {
      // Fix: k & n - k - 1
      // Move: i & n - i - 1
      for (int i = k; i < n - k - 1; i++) { // top <-> right
        swap(matrix, k, i, i, n - k - 1);
      }
      for (int i = k; i < n - k - 1; i++) { // top <-> bottom
        swap(matrix, k, i, n - k - 1, n - i - 1);
      }
      for (int i = k; i < n - k - 1; i++) { // top <-> left
        swap(matrix, k, i, n - i - 1, k);
      }
    }
  }

  private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
    int tmp = matrix[i1][j1];
    matrix[i1][j1] = matrix[i2][j2];
    matrix[i2][j2] = tmp;
  }
}
