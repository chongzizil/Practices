package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by youlongli on 2/8/15.
 *
 * https://oj.leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {
  /**
   * runtime: 255ms
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public boolean solutionA(TreeNode root) {
    if (root == null) {
      return true;
    }

    return helper(root.left, root.right);
  }

  private boolean helper(TreeNode left, TreeNode right) {
    if (left == null ^ right == null) {
      return false;
    }

    if (left == null && right == null) {
      return true;
    }

    if (left.val != right.val) {
      return false;
    }

    return helper(left.left, right.right) && helper(left.right, right.left);
  }

  /**
   * Iterative, DFS (BFS can also be used by check level by level, although it would be more complex)
   */
  public boolean solutionB(TreeNode root) {
    // Few corner cases
    if (root == null) {
      return true;
    } else if (root.left == null ^ root.right == null) {
      return false;
    } else if (root.left == null && root.right == null) {
      return true;
    }

    // Use two stack to check between left subtree and right subtree using DFS
    Deque<TreeNode> stack1 = new ArrayDeque<TreeNode>();
    Deque<TreeNode> stack2 = new ArrayDeque<TreeNode>();
    stack1.add(root.left);
    stack2.add(root.right);

    while (!stack1.isEmpty()) {
      if (stack1.peek().val != stack2.peek().val) {
        return false;
      }

      TreeNode leftNode = stack1.pop();
      TreeNode rightNode = stack2.pop();

      if ((leftNode.left == null ^ rightNode.right == null) || (leftNode.right == null ^ rightNode.left == null)) {
        return false;
      }

      if (leftNode.left != null && rightNode.right != null) {
        stack1.push(leftNode.left);
        stack2.push(rightNode.right);
      }

      if (leftNode.right != null && rightNode.left != null) {
        stack1.push(leftNode.right);
        stack2.push(rightNode.left);
      }
    }

    return true;
  }
}
