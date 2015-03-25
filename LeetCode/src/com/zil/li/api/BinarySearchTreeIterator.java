package com.zil.li.api;

import com.zil.li.datastructure.TreeNode;

import java.util.*;

/**
 * Created by youlongli on 3/5/15.
 *
 * https://oj.leetcode.com/submissions/detail/20972800/
 */
public class BinarySearchTreeIterator {
  /**
   * Basically use the inorder traversal in real time.
   * next() a& hasNext average time complexity: O(1)
   * Space complexity: O(h)
   */
  public class BSTIteratorA {
    Stack<TreeNode> stack;

    public BSTIteratorA(TreeNode root) {
      stack = new Stack<TreeNode>();
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
      return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
      TreeNode node = stack.pop();
      int res = node.val;

      if (node.right != null) {
        node = node.right;
        while (node != null) {
          stack.push(node);
          node = node.left;
        }
      }

      return res;
    }
  }

  /**
   * Basically use the inorder traversal during the construct time.
   * next() a& hasNext average time complexity: O(1)
   * Space complexity: O(n)
   */
  public class BSTIteratorB {
    private List<Integer> nodes = new ArrayList<Integer>();
    private int index = 0;

    public BSTIteratorB(TreeNode root) {
      if (root == null) {
        return;
      }

      Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
      TreeNode curr = root;

      while (true) {
        while (curr != null) {
          stack.push(curr);
          curr = curr.left;
        }

        if (stack.isEmpty()) {
          break;
        }

        curr = stack.pop();
        nodes.add(curr.val);
        curr = curr.right;
      }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
      return index < nodes.size();
    }

    /** @return the next smallest number */
    public int next() {
      return nodes.get(index++);
    }
  }
}
