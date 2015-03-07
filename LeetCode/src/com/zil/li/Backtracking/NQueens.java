package com.zil.li.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 2/28/15.
 *
 * https://oj.leetcode.com/problems/n-queens/
 */
public class NQueens {
  public List<String[]> solveNQueens(int n) {
    List<String[]> res = new ArrayList<String[]>();
    int[] cols = new int[n]; // column position of each rows

    helper(res, cols, 0, n);

    return res;
  }

  private void helper(List<String[]> res, int[] cols, int row, int n) {
    if (row == n) {
      res.add(drawBoard(cols, n));
    }

    for (int i = 0; i < n; i++) {
      if (isValid(cols, row, i)) {
        cols[row] = i;
        helper(res, cols, row + 1, n);
        cols[row] = -1; // No need to reset it actually... Since we also pass the current row index.
      }
    }
  }

  private boolean isValid(int[] cols, int row, int col) {
    for (int i = 0; i < row; i++) {
      // Vertically
      if (cols[i] == col) {
        return false;
      }
      // Diagonally
      if (Math.abs(row - i) == Math.abs(cols[i] - col)) {
        return false;
      }
    }

    return true;
  }

  private String[] drawBoard(int[] cols, int n) {
    String[] res = new String[n];
    for (int i = 0; i < n; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < cols[i]; j++) {
        sb.append('.');
      }
      sb.append('Q');
      for (int j = cols[i] + 1; j < n; j++) {
        sb.append('.');
      }
      res[i] = sb.toString();
    }

    return res;
  }
}
