package com.zil.li.Backtracking;

/**
 * Created by youlongli on 2/28/15.
 */
public class NQueensII {
  int sum = 0;
  public int totalNQueens(int n) {
    if (n <= 0) {
      return 0;
    }

    int[] cols = new int[n];
    search(cols, 0);

    return sum;
  }

  private void search(int[] cols, int row) {
    int n = cols.length;

    if (row == n) {
      sum++;
      return;
    }

    for (int i = 0; i < n; i++) {
      if (isValid(cols, i, row)) {
        cols[row] = i;
        search(cols, row + 1);
      }
    }
  }

  private boolean isValid(int[] cols, int col, int row) {
    for (int i = 0; i < row; i++) {
      if (col == cols[i]) {
        return false;
      }

      if (Math.abs(col - cols[i]) == Math.abs(row - i)) {
        return false;
      }
    }

    return true;
  }
}
