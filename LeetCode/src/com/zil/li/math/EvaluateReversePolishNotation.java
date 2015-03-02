package com.zil.li.math;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlongli on 3/1/15.
 *
 * https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation {
  /**
   * Just use stack...
   */
  public int solutionA(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<Integer>();
    Map<String, Integer> operators = new HashMap<String, Integer>();
    operators.put("+", 1);
    operators.put("-", 1);
    operators.put("*", 1);
    operators.put("/", 1);

    for (String token : tokens) {
      if (operators.containsKey(token)) {
        // Note: Be careful of the order.
        int n2 = stack.pop();
        int n1 = stack.pop();
        stack.push(eval(token, n1, n2));
      } else {
        stack.push(Integer.parseInt(token));
      }
    }

    return stack.pop();
  }

  private int eval(String operator, int n1, int n2) {
    switch(operator) {
      case "+": return n1 + n2;
      case "-": return n1 - n2;
      case "*": return n1 * n2;
      default: return n1 / n2;
    }
  }

  /**
   * More general solution where new operator are easy to add without DRY
   */
  private interface Operator {
    int eval(int n1, int n2);
  }

  public int solutionB(String[] tokens) {
    Map<String, Operator> operators = new HashMap<String, Operator>();
    Deque<Integer> stack = new ArrayDeque<Integer>();

    operators.put("+", new Operator() {
      public int eval(int n1, int n2) { return n1 + n2; }
    });
    operators.put("-", new Operator() {
      public int eval(int n1, int n2) { return n1 - n2; }
    });
    operators.put("*", new Operator() {
      public int eval(int n1, int n2) { return n1 * n2; }
    });
    operators.put("/", new Operator() {
      public int eval(int n1, int n2) { return n1 / n2; }
    });

    for (String token : tokens) {
      if (operators.containsKey(token)) {
        int n2 = stack.pop();
        int n1 = stack.pop();
        stack.push(operators.get(token).eval(n1, n2));
      } else {
        stack.push(Integer.parseInt(token));
      }
    }

    return stack.pop();
  }
}
