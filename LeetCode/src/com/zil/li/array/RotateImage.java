package com.zil.li.array;

/**
 * Created by youlongli on 3/10/15.
 *
 * https://leetcode.com/problems/rotate-image/
 */
public class RotateImage {
  public void rotate(int[][] matrix) {
    int n = matrix.length;

    for (int i = 0; i < n / 2; i++) {
      // Fix: i & n - i - 1
      // Move: j & n - j - 1
      for (int j = i; j < n - i - 1; j++) { // top <-> right
        swap(matrix, i, j, j, n - i - 1);
      }
      for (int j = i; j < n - i - 1; j++) { // top <-> bottom
        swap(matrix, i, j, n - i - 1, n - j - 1);
      }
      for (int j = i; j < n - i - 1; j++) { // top <-> left
        swap(matrix, i, j, n - j - 1, i);
      }
    }
  }

  private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
    int tmp = matrix[i1][j1];
    matrix[i1][j1] = matrix[i2][j2];
    matrix[i2][j2] = tmp;
  }
}
