package com.zil.li.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by youlongli on 3/12/15.
 *
 * https://leetcode.com/problems/surrounded-regions/
 *
 * Idea:
 * If a region has at least one piece on the side of the matrix, then the region is not surrounded.
 * So we can use BFS to check every side position.
 */
public class SurroundedRegions {
  public void solve(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return;
    }

    int m = board.length;
    int n = board[0].length;

    // Check the left side and right side
    for (int i = 0; i < m; i++) {
      bfs(board, i, 0);
      bfs(board, i, n - 1);
    }

    // Check the top and bottom
    for (int i = 1; i < n - 1; i++) {
      bfs(board, 0, i);
      bfs(board, m - 1, i);
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'O') {
          // Captured/Surrounded
          board[i][j] = 'X';
        } else if (board[i][j] == 'R') {
          // Free
          board[i][j] = 'O';
        }
      }
    }
  }

  private void bfs(char[][] board, int i, int j) {
    Queue<Integer> queue = new LinkedList<Integer>();
    int m = board.length;
    int n = board[0].length;

    queue.offer(i * n + j);

    while (!queue.isEmpty()) {
      int index = queue.poll();

      if (index < 0 || index >= m * n) {
        continue;
      }

      int row = index / n;
      int col = index % n;

      if (board[row][col] != 'O') {
        continue;
      }

      // Color the position to indicate free position
      board[row][col] = 'R';
      queue.add(index - 1);
      queue.add(index + 1);
      queue.add(index - n);
      queue.add(index + n);
    }
  }
}
