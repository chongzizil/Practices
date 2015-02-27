package com.zil.li.DP;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by youlongli on 2/26/15.
 */
public class LongestValidParentheses {
  public int longestValidParentheses(String s) {
    if (s == null || s.length() < 2) {
      return 0;
    }

    int sum = 0;
    int max = 0;
    int n = s.length();
    Deque<Integer> stack = new ArrayDeque<Integer>();

    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {
        if (stack.isEmpty()) {
          // Start a new count
          sum = 0;
        } else {
          int start = stack.pop();
          if (stack.isEmpty()) {
            // Update sum
            sum += i - start + 1;
            max = Math.max(max, sum);
          } else {
            max = Math.max(max, i - stack.peek());
          }
        }
      }
    }

    return max;
  }
}
