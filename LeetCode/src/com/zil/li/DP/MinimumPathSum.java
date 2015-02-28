package com.zil.li.DP;

/**
 * Created by youlongli on 2/22/15.
 */
public class MinimumPathSum {
  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int m = grid.length;
    int n = grid[0].length;
    int[][] minPath = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          minPath[i][j] = grid[i][j];
        } else if (i == 0) {
          minPath[i][j] = minPath[i][j - 1] + grid[i][j];
        } else if (j == 0) {
          minPath[i][j] = minPath[i - 1][j] + grid[i][j];
        } else {
          minPath[i][j] = Math.min(minPath[i - 1][j], minPath[i][j - 1]) + grid[i][j];
        }
      }
    }

    return minPath[m - 1][n - 1];
  }
}
