package com.zil.li.hashtable;

import java.util.Arrays;

/**
 * Created by youlongli on 3/7/15.
 *
 * https://oj.leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    boolean[] visited = new boolean[9];

    for (int i = 0; i < 9; i++) {
      Arrays.fill(visited, false);
      for (int j = 0; j < 9; j++) {
        if (!process(visited, board[i][j])) {
          return false;
        }
      }
    }

    for (int i = 0; i < 9; i++) {
      Arrays.fill(visited, false);
      for (int j = 0; j < 9; j++) {
        if (!process(visited, board[j][i])) {
          return false;
        }
      }
    }

    for(int i = 0; i < 9; i += 3){
      for(int j = 0; j < 9; j += 3){
        Arrays.fill(visited, false);
        for(int k = 0; k < 9; k++){
          if (!process(visited, board[i + k / 3][ j + k % 3])) {
            return false;
          }
        }
      }
    }

//    for (int i = 0; i < 9; i++) { // Square
//      Arrays.fill(visited, false);
//      for (int j = 0; j < 9; j++) {
//        int row = (i / 3) * 3 + j / 3;
//        int col = (i % 3) * 3 + j % 3;
//        if (!process(visited, board[row][col])) {
//          return false;
//        }
//      }
//    }

    return true;
  }

  private boolean process(boolean[] visited, char digit) {
    if (digit == '.') {
      return true;
    }

    int num = digit - '0';
    if (num < 1 || num > 9 || visited[num - 1]) {
      return false;
    }

    visited[num - 1] = true;
    return true;
  }
}
