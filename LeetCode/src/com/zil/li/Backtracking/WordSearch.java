package com.zil.li.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 3/2/15.
 *
 * https://oj.leetcode.com/problems/word-search/
 */
public class WordSearch {
  /**
   * One cleaner solution without using global variable and more space.
   */
  public boolean solutionA(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (search(board, word, 0, i, j)) {
          return true;
        }
      }
    }

    return false;
  }

  /**
   * @param i the current index of the word
   */
  private boolean search(char[][] board, String word, int i, int row, int col) {
    int m = board.length;
    int n = board[0].length;

    if (row < 0 || row >= m || col < 0 || col >= n
        || board[row][col] == '#'
        || board[row][col] != word.charAt(i)) {
      return false;
    }

    if (i == word.length() - 1) {
      return true;
    }

    board[row][col] = '#';
    boolean res = search(board, word, i + 1, row - 1, col)
        || search(board, word, i + 1, row + 1, col)
        || search(board, word, i + 1, row, col - 1)
        || search(board, word, i + 1, row, col + 1);
    board[row][col] = word.charAt(i);
    return res;
  }

  /**
   *
   */
  private boolean res;
  public boolean solutionB(char[][] board, String word) {
    res = false;
    if (board == null || board.length == 0 || word.length() == 0) {
      return res;
    }

    int m = board.length;
    int n = board[0].length;
    List<Character> chars = new ArrayList<Character>();
    boolean[][] visited = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!res) {
          helperB(board, visited, word, chars, i, j);
        }
      }
    }

    return res;
  }

  private void helperB(char[][] board, boolean[][] visited, String word, List<Character> chars, int i, int j) {
    if (res || visited[i][j]) {
      return;
    }

    if (board[i][j] != word.charAt(chars.size())) {
      return;
    }

    chars.add(board[i][j]);
    visited[i][j] = true;
    if (chars.size() == word.length()) {
      res = true;
      return;
    }

    int m = board.length;
    int n = board[0].length;
    if (j > 0) { // left
      helperB(board, visited, word, chars, i, j - 1);
    }
    if (j < n - 1) { // right
      helperB(board, visited, word, chars, i, j + 1);
    }
    if (i > 0) { // up
      helperB(board, visited, word, chars, i - 1, j);
    }
    if (i < m - 1) { // down
      helperB(board, visited, word, chars, i + 1, j);
    }
    visited[i][j] = false;
    chars.remove(chars.size() - 1);
  }
}
