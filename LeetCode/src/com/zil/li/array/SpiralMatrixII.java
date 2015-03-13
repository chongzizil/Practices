package com.zil.li.array;

/**
 * Created by youlongli on 3/10/15.
 *
 * https://leetcode.com/problems/spiral-matrix-ii/
 */
public class SpiralMatrixII {
  public int[][] generateMatrix(int n) {
    int[][] res = new int[n][n];
    int elem = 0;
    int m = n;
    int row = 0;
    int col = -1;

    while (true) {
      for (int i = 0; i < n; i++) {
        res[row][++col] = ++elem;
      }
      if (--m <= 0) break; // Check if --m < 0, because n might be 0 at first
      for (int i = 0; i < m; i++) {
        res[++row][col] = ++elem;
      }
      if (--n <= 0) break;
      for (int i = 0; i < n; i++) {
        res[row][--col] = ++elem;
      }
      if (--m <= 0) break;
      for (int i = 0; i < m; i++) {
        res[--row][col] = ++elem;
      }
      if (--n <= 0) break;
    }

    return res;
  }
}
