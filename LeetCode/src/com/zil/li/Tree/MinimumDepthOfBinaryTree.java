package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

/**
 * Created by youlongli on 2/9/15.
 *
 * https://oj.leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return helper(root);
  }

  private int helper(TreeNode root) {
    if (root == null) {
      // NOTE: Set the invalid/null node as Integer.MAX_VALUE.
      return Integer.MAX_VALUE;
    }

    if (root.left == null && root.right == null) {
      return 1;
    }

    return Math.min(helper(root.left), helper(root.right)) + 1;
  }

  /**
   * This one use more codes... Just check the null node instead of the leaf node seems a much better idea...
   */
  private int helperB(TreeNode root) {
    if (root.left == null && root.right == null) {
      return 1;
    }

    int minL = Integer.MAX_VALUE;
    int minR = Integer.MAX_VALUE;

    if (root.left != null) {
      minL = helper(root.left);
    }
    if (root.right != null) {
      minR = helper(root.right);
    }

    return Math.min(minL, minR) + 1;
  }
}
