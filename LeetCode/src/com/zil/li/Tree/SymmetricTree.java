package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

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
  public boolean isSymmetric(TreeNode root) {
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
}
