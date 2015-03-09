package com.zil.li.DP;

/**
 * Created by youlongli on 2/22/15.
 *
 * https://oj.leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathsII {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
      return 0;
    }

    int row = obstacleGrid.length;
    int col = obstacleGrid[0].length;
    int[][] path = new int[row][col];

    for (int i = 0; i < row; i++) {
      if (obstacleGrid[i][0] == 1) {
        break;
      } else {
        path[i][0] = 1;
      }
    }

    for (int i = 0; i < col; i++) {
      if (obstacleGrid[0][i] == 1) {
        break;
      } else {
        path[0][i] = 1;
      }
    }

    // Note: Starts from 1.
    for (int i = 1; i < row; i++) {
      for (int j = 1; j < col; j++) {
        if (obstacleGrid[i][j] == 0) {
          path[i][j] = path[i - 1][j] + path[i][j - 1];
        }
      }
    }

    return path[row - 1][col - 1];
  }
}
