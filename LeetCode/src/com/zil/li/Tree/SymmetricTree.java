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
   */
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return helper(root.left, root.right);
  }

  private boolean helper(TreeNode l, TreeNode r) {
    if (l == null ^ r == null) {
      return false;
    }
    if (l == null && r == null) {
      return true;
    }
    if (l.val != r.val) {
      return false;
    }

    return helper(l.left, r.right) && helper(l.right, r.left);
  }
}
