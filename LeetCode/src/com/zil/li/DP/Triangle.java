package com.zil.li.DP;

import java.util.List;

/**
 * Created by youlongli on 2/22/15.
 */
public class Triangle {
  /**
   * Top-Bottom
   */
  public int SolutionA(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
      return 0;
    }

    int n = triangle.size();
    int res = Integer.MAX_VALUE;
    int[][] dp = new int[n][n];

    dp[0][0] = triangle.get(0).get(0);

    for (int i = 1; i < n; i++) {
      // Note it's j <= i instead of j < i
      for (int j = 0; j <= i; j++) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (j != 0) {
          left = dp[i - 1][j - 1];
        }
        if (j != i) {
          right = dp[i - 1][j];
        }
        dp[i][j] = Math.min(left, right) + triangle.get(i).get(j);
      }
    }

    for (int i = 0; i < n; i++) {
      res = Math.min(dp[n - 1][i], res);
    }

    return res;
  }

  /**
   * Bottom-top
   */
  public int solutionB(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
      return 0;
    }

    int n = triangle.size();
    int[][] dp = new int[n][n];

    for (int i = 0; i < n; i++) {
      dp[n - 1][i] = triangle.get(n - 1).get(i);
    }

    for (int i = n - 2; i >= 0; i--) {
      // Note it's j <= i instead of j < i
      for (int j = 0; j <= i; j++) {
        dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
      }
    }

    return dp[0][0];
  }

  /**
   * Memorize
   */
  public int solutionC(List<List<Integer>> triangle) {
    int row = triangle.size();
    int col = triangle.get(row - 1).size();
    int[][] dp = new int[row][col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        dp[i][j] = Integer.MAX_VALUE;
      }
    }

    return helper(triangle, dp, 0, 0);
  }

  private int helper(List<List<Integer>> triangle, int[][] dp, int x, int y) {
    if (x == triangle.size() - 1) {
      return triangle.get(x).get(y);
    }

    if (dp[x][y] != Integer.MAX_VALUE) {
      return dp[x][y];
    }

    int left = helper(triangle, dp, x + 1, y);
    int right = helper(triangle, dp, x + 1, y + 1);
    dp[x][y] = Math.min(left, right) + triangle.get(x).get(y);
    return dp[x][y];
  }
}
