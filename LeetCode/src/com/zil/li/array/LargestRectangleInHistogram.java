package com.zil.li.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by youlongli on 2/23/15.
 *
 * https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleInHistogram {
  public int largestRectangleArea(int[] height) {
    int maxArea = 0;
    int[] h = new int[height.length + 1];
    Deque<Integer> stack = new ArrayDeque<Integer>(); // Index

    for (int i = 0; i < height.length; i++) {
      h[i] = height[i];
    }

    int i = 0;
    while (i < h.length) {
      if (stack.isEmpty() || h[i] >= h[stack.peek()]) {
        stack.push(i++);
      } else {
        int j = stack.pop();
        maxArea = Math.max(maxArea, h[j] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
      }
    }

    return maxArea;
  }
}
