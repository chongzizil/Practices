package com.zil.li.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 3/1/15.
 *
 * https://oj.leetcode.com/problems/spiral-matrix/
 *
 * Idea:
 * After each time we move to the end, we check if there's any more rows or columns.
 */
public class SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<Integer>();

    if (matrix == null || matrix.length == 0) {
      return res;
    }

    int m = matrix.length;
    int n = matrix[0].length;
    int row = 0;
    int col = -1;
    while (true) {
      for (int i = 0; i < n; i++) {
        res.add(matrix[row][++col]); // Right
      }
      if (--m == 0) break; // Finish one row
      for (int i = 0; i < m; i++) {
        res.add(matrix[++row][col]); // Down
      }
      if (--n == 0) break; // Finish One column
      for (int i = 0; i < n; i++) {
        res.add(matrix[row][--col]); // Left
      }
      if (--m == 0) break; // Finish one row
      for (int i = 0; i < m; i++) {
        res.add(matrix[--row][col]); // Up
      }
      if (--n == 0) break; // Finish One column
    }

    return res;
  }
}
