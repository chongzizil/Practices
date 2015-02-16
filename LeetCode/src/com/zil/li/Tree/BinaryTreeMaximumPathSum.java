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
    public Result(int max, int maxSingle) {
      this.max = max;
      this.maxSingle = maxSingle;
    }
  }

  public int maxPathSum(TreeNode root) {
    return helper(root).max;
  }

  private Result helper(TreeNode root) {
    Result res = new Result(Integer.MIN_VALUE, Integer.MIN_VALUE);
    if (root == null) {
      return res;
    }

    Result leftRes = helper(root.left);
    Result rightRes = helper(root.right);

    int cross = root.val;
    cross += Math.max(0, leftRes.maxSingle);
    cross += Math.max(0, rightRes.maxSingle);

    res.maxSingle = Math.max(leftRes.maxSingle, rightRes.maxSingle);
    res.maxSingle = Math.max(0, res.maxSingle) + root.val;

    res.max = Math.max(leftRes.max, rightRes.max);
    res.max = Math.max(res.max, cross);
    return res;
  }
}
