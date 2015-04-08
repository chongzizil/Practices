package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

/**
 * Created by youlongli on 2/9/15.
 *
 * Assume (null, 0) is not valid.
 *
 * https://oj.leetcode.com/problems/path-sum/
 */
public class PathSum {
  /**
   * DFS...
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public boolean solutionA(TreeNode root, int sum) {
    if (root == null) {
      return false;
    } else if (root.left == null && root.right == null && sum == root.val) {
      return true;
    }

    return solutionA(root.left, sum - root.val) || solutionA(root.right, sum - root.val);
  }

  /**
   * Not much different...
   */
  public boolean solutionB(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }

    if (root.left == null && root.right == null) {
      return sum == root.val;
    }

    return solutionB(root.left, sum - root.val) || solutionB(root.right, sum - root.val);
  }
}
