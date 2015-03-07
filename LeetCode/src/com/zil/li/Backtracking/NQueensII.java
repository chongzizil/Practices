package com.zil.li.Backtracking;

/**
 * Created by youlongli on 2/28/15.
 *
 * https://oj.leetcode.com/problems/n-queens-ii/
 */
public class NQueensII {
  public int totalNQueens(int n) {
    int[] cols = new int[n];

    return helper(cols, 0, n);
  }

  private int helper(int[] cols, int row, int n) {
    if (row == n) {
      return 1;
    }

    int sum = 0;

    for (int i = 0; i < n; i++) {
      if (isValid(cols, row, i)) {
        cols[row] = i;
        sum += helper(cols, row + 1, n);
      }
    }

    return sum;
  }

  private boolean isValid(int[] cols, int row, int col) {
    for (int i = 0; i < row; i++) {
      // Vertically
      if (cols[i] == col) {
        return false;
      }
      // Diagonal
      if (Math.abs(row - i) == Math.abs(cols[i] - col)) {
        return false;
      }
    }

    return true;
  }
}
