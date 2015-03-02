package com.zil.li.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlongli on 3/1/15.
 *
 * https://oj.leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
  /**
   * Concise solution compare with solution B.
   */
  public boolean solutionA(String s) {
    Map<Character, Character> map = new HashMap<Character, Character>();
    Deque<Character> stack = new ArrayDeque<Character>();

    map.put('(', ')');
    map.put('[', ']');
    map.put('{', '}');

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        stack.push(c);
      } else {
        if (stack.isEmpty() || map.get(stack.pop()) != c) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }

  public boolean solutionB(String s) {
    Deque<Character> stack = new ArrayDeque<Character>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }

        char l = stack.pop();
        if ((l == '(' && c == ')')
            || (l == '[' && c == ']')
            || (l == '{' && c == '}')) {
          continue;
        }
        return false;
      }
    }

    return stack.isEmpty();
  }
}
