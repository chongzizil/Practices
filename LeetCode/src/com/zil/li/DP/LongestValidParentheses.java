package com.zil.li.DP;

import java.util.Stack;

/**
 * Created by youlongli on 2/26/15.
 */
public class LongestValidParentheses {
  public int longestValidParentheses(String s) {
    if (s == null || s.length() < 2) {
      return 0;
    }

    Stack<Integer> stack = new Stack<>();
    int sum = 0;
    int res = 0;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.push(i);
      } else {
        if (stack.isEmpty()) {
          sum = 0;
          continue;
        }

        int j = stack.pop();

        if (stack.isEmpty()) {
          sum += i - j + 1;
          res = Math.max(res, sum);
        } else {
          res = Math.max(res, i - stack.peek());
        }
      }
    }

    return res;
  }
}
