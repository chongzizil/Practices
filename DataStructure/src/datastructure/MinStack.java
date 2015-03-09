package datastructure;

import java.util.Stack;

/**
 * Created by youlongli on 3/1/15.
 *
 * https://oj.leetcode.com/problems/min-stack/
 *
 * 1. Make sure to consider the duplicates
 */
public class MinStack {
  private Stack<Integer> stack = new Stack<Integer>();
  private Stack<Integer> minStack = new Stack<Integer>();

  public void push(int x) {
    stack.push(x);
    if (minStack.isEmpty() || x <= minStack.peek()) {
      minStack.push(x);
    }
  }

  public void pop() {
    if (stack.pop().equals(minStack.peek())) {
      minStack.pop();
    }
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}
