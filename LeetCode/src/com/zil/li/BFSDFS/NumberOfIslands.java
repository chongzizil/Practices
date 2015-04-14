package com.zil.li.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by youlongli on 4/12/15.
 *
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {
  /**
   * DFS
   */
  public int numIslandsDFS(char[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int m = grid.length;
    int n = grid[0].length;
    int num = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          mark(grid, i, j);
          num++;
        }
      }
    }

    return num;
  }

  private void mark(char[][] grid, int i, int j) {
    int m = grid.length;
    int n = grid[0].length;

    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
      return;
    }

    grid[i][j] = '2';
    mark(grid, i + 1, j);
    mark(grid, i - 1, j);
    mark(grid, i, j + 1);
    mark(grid, i, j - 1);
  }

  /**
   * BFS
   */
  private class Node {
    int row;
    int col;

    public Node(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  public int numIslandsBFS(char[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int m = grid.length;
    int n = grid[0].length;
    int num = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          markBFS(grid, i, j);
          num++;
        }
      }
    }

    return num;
  }

  private void markBFS(char[][] grid, int i, int j) {
    Queue<Node> queue = new LinkedList<>();
    int m = grid.length;
    int n = grid[0].length;

    queue.offer(new Node(i, j));
    while (!queue.isEmpty()) {
      Node node = queue.poll();

      if (node.row < 0 || node.row >= m || node.col < 0 || node.col >= n || grid[node.row][node.col] != '1') {
        continue;
      }

      grid[node.row][node.col] = '2';

      queue.offer(new Node(node.row + 1, node.col));
      queue.offer(new Node(node.row - 1, node.col));
      queue.offer(new Node(node.row, node.col + 1));
      queue.offer(new Node(node.row, node.col - 1));
    }
  }
}
