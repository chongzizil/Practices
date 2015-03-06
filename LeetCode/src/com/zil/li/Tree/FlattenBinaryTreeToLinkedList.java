package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

/**
 * Created by youlongli on 2/11/15.
 *
 * https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
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
    // Note: first cleat the child node
    root.left = null;
    root.right = null;

    // Note: remember to check if the child node is null
    if (left != null) {
      tail.right = left; // append the subtree
      tail = helper(left); // update the tail
    }

    if (right != null) {
      tail.right = right; // append the subtree
      tail = helper(right); // update the tail
    }

    return tail;
  }
}
