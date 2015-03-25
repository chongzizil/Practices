package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

/**
 * Created by youlongli on 2/11/15.
 *
 * Idea: http://www.cnblogs.com/yuzhangcmu/p/4208319.html
 */
public class RecoverBinarySearchTree {
  /**
   * This solution use constant space.
   */
  private TreeNode first = null;
  private TreeNode second = null;
  private TreeNode prev = null;

  public void recoverTree(TreeNode root) {
    traverse(root);

    int tmp = first.val;
    first.val = second.val;
    second.val = tmp;
  }

  private void traverse(TreeNode root) {
    if (root == null) {
      return;
    }

    traverse(root.left);

    if (prev != null && root.val < prev.val) {
      if (first == null) {
        first = prev;
      }
      // Note: Do not use if-else. E.g. (2, 1) We will have first and second in the same time.
      if (first != null) {
        second = root;
      }
    }

    prev = root;

    traverse(root.right);
  }
}
