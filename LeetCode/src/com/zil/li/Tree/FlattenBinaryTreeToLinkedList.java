package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

/**
 * Created by youlongli on 2/11/15.
 */
public class FlattenBinaryTreeToLinkedList {
  public void flatten(TreeNode root) {
    helper(root);
  }

  private TreeNode helper(TreeNode root) {
    if (root == null) {
      return null;
    }

    TreeNode left = root.left;
    TreeNode right = root.right;
    TreeNode tail = root;
    root.left = null;
    root.right = null;

    if (left != null) {
      tail.right = left;
      tail = helper(left);
    }

    if (right != null) {
      tail.right = right;
      tail = helper(right);
    }

    return tail;
  }
}
