package com.zil.li.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 3/2/15.
 */
public class WordSearch {
  /**
   * One cleaner solution without using global variable and more space.
   */
  public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0 || word.length() == 0) {
      return false;
    }

    int m = board.length;
    int n = board[0].length;
    List<Character> chars = new ArrayList<Character>();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (helper(board, word, chars, i, j)) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean helper(char[][] board, String word, List<Character> chars, int i, int j) {
    int m = board.length;
    int n = board[0].length;

    // Note: Check the index first!
    if (i < 0 || i >= m || j < 0 || j >= n
        || board[i][j] != word.charAt(chars.size())
        || board[i][j] == '#') {
      return false;
    }

    chars.add(board[i][j]);
    board[i][j] = '#'; // Visited
    if (chars.size() == word.length()) {
      return true;
    }

    boolean res = helper(board, word, chars, i, j - 1)
        || helper(board, word, chars, i, j + 1)
        || helper(board, word, chars, i - 1, j)
        || helper(board, word, chars, i + 1, j);

    board[i][j] = chars.get(chars.size() - 1);
    chars.remove(chars.size() - 1);
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
