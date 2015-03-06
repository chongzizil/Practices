package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

/**
 * Created by youlongli on 2/8/15.
 *
 * https://oj.leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {
  /**
   * Runtime: 272 ms
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public boolean solution(TreeNode root) {
    return getMaxDepth(root) != -1;
  }

  // Return the max depth of the tree, if the tree is not balanced, return -1.
  private int getMaxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftDepth = getMaxDepth(root.left);
    int rightDepth = getMaxDepth(root.right);

    if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) {
      return -1;
    }

    return Math.max(leftDepth, rightDepth) + 1;
  }
}
