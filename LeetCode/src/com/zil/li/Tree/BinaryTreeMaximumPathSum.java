package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

/**
 * Created by youlongli on 2/11/15.
 *
 * https://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * Idea: There're three cases.
 * 1. The max sum exists in the left subtree.
 * 2. The max sum exists in the right subtree.
 * 3. The max sum across the root and exists in both subtree.
 *
 * Hence we need two return value.
 * 1. Maximum path sum in that subtree.
 * 2. Maximum path sum start from the root in that subtree.
 */
public class BinaryTreeMaximumPathSum {
  /**
   * Runtime: 340 ms
   */
  private class Result {
    int max;
    int maxSingle;
    public Result() {
      max = Integer.MIN_VALUE;
      maxSingle = Integer.MIN_VALUE;
    }
  }

  public int maxPathSum(TreeNode root) {
    return helper(root).max;
  }

  private Result helper(TreeNode node) {
    Result res = new Result();

    if (node == null) {
      return res;
    }

    Result l = helper(node.left);
    Result r = helper(node.right);

    int cross = node.val;
    cross += Math.max(0, l.maxSingle);
    cross += Math.max(0, r.maxSingle);

    res.max = Math.max(cross, Math.max(l.max, r.max));
    res.maxSingle = Math.max(0, Math.max(l.maxSingle, r.maxSingle)) + node.val;

    return res;
  }
}
