package com.zil.li.DP;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by youlongli on 2/23/15.
 *
 * https://oj.leetcode.com/problems/maximal-rectangle/
 * http://www.cnblogs.com/yuzhangcmu/p/4107350.html
 */
public class MaximalRectangle {
  /**
   * The idea comes from the problem LargestRectangleInHistogram (The helper function).
   * Think of those rectangles comprised from bars of histogram.
   */
  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int res = 0;
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] h = new int[m][n + 1];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0) {
          h[i][j] = matrix[i][j] == '1' ? 1 : 0;
        } else {
          h[i][j] = matrix[i][j] == '1' ? h[i - 1][j] + 1 : 0;
        }
      }

      res = Math.max(res, maxArea(h[i]));
    }

    return res;
  }

  private int maxArea(int[] h) {
    int i = 0;
    int res = 0;
    Deque<Integer> stack = new ArrayDeque<Integer>();

    while (i < h.length) {
      if (stack.isEmpty() || (h[i] > h[stack.peek()])) {
        stack.push(i++);
      } else {
        int j = stack.pop();
        res = Math.max(res, h[j] * (stack.isEmpty() ? i : i - stack.peek() - 1));
      }
    }

    return res;
  }
}
