package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

/**
 * Created by youlongli on 2/8/15.
 *
 * https://oj.leetcode.com/problems/same-tree/
 */
public class SameTree {
  /**
   * Runtime: 206 ms
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null ^ q == null) {
      return false;
    }

    if (p == null && q == null) {
      return true;
    }

    if (p.val != q.val) {
      return false;
    }

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
