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
    int[] rows = new int[n]; // column position of each rows

    helper(res, rows, 0, n);

    return res;
  }

  private void helper(List<String[]> res, int[] rows, int row, int n) {
    if (row == n) {
      res.add(drawBoard(rows, n));
    }

    for (int i = 0; i < n; i++) {
      if (isValid(rows, row, i)) {
        rows[row] = i;
        helper(res, rows, row + 1, n);
        rows[row] = -1; // No need to reset it actually... Since we also pass the current row index.
      }
    }
  }

  private boolean isValid(int[] rows, int row, int col) {
    for (int i = 0; i < row; i++) {
      // Vertically
      if (rows[i] == col) {
        return false;
      }
      // Diagonally
      if (Math.abs(row - i) == Math.abs(rows[i] - col)) {
        return false;
      }
    }

    return true;
  }

  private String[] drawBoard(int[] rows, int n) {
    String[] res = new String[n];
    for (int i = 0; i < n; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < rows[i]; j++) {
        sb.append('.');
      }
      sb.append('Q');
      for (int j = rows[i] + 1; j < n; j++) {
        sb.append('.');
      }
      res[i] = sb.toString();
    }

    return res;
  }
}
