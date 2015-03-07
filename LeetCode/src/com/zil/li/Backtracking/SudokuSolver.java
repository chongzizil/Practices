package com.zil.li.Backtracking;

/**
 * Created by youlongli on 3/6/15.
 *
 * https://oj.leetcode.com/problems/sudoku-solver/
 */
public class SudokuSolver {
  public void solveSudoku(char[][] board) {
    search(board, 0, 0);
  }

  private boolean search(char[][] board, int i, int j) {
    if (j == 9) {
      return search(board, i + 1, 0); // Move to next row
    }

    if (i == 9) {
      return true; // Done
    }

    if (board[i][j] != '.') {
      return search(board, i, j + 1);
    }

    for (char num = '1'; num <= '9'; num++) { // Start from char '1' to '9', or use '1' + i where i starts from 0 to 8
      board[i][j] = num;
      if (isValid(board, num, i, j) && search(board, i, j + 1)) {
        return true;
      }
      board[i][j] = '.';
    }

    return false;
  }

  private boolean isValid(char[][] board, char num, int row, int col) {
    int m = board.length;
    int n = board[0].length;

    // Check row (Vertical)
    for (int i = 0; i < m; i++) {
      if (i != row && board[i][col] == num) {
        return false;
      }
    }

    // Check col (horizontal)
    for (int i = 0; i < n; i++) {
      if (i != col && board[row][i] == num) {
        return false;
      }
    }

    // Check block
    for (int k = 0; k < 9; k++) {
      int i = (row / 3) * 3 + k / 3; // row / 3 is the index of the block vertically, then * 3 we have the start row of that block
      int j = (col / 3) * 3 + k % 3;
      if (i == row && j == col) {
        continue;
      }
      if (board[i][j] == num) {
        return false;
      }
    }

    return true;
  }
}
