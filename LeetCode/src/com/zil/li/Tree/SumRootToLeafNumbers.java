package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

/**
 * Created by youlongli on 2/11/15.
 *
 * https://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRootToLeafNumbers {
  /**
   * Runtime: 202 ms
   */
  public int solutionA(TreeNode root) {
    return helper(root, 0);
  }

  private int helper(TreeNode root, int sum) {
    if (root == null) {
      return 0; // Return 0 if the node if null
    }

    // calculate the current sum first
    sum = sum * 10 + root.val;
    // If the node if leaf node, just return the sum
    if (root.left == null && root.right == null) {
      return sum;
    }

    return helper(root.left, sum) + helper(root.right, sum);
  }

  /**
   * Store the result as global variable
   */
  private int sum = 0;

  public int solutionB(TreeNode root) {
    helperB(root, 0);

    return sum;
  }

  public void helperB(TreeNode root, int num) {
    if (root == null) {
      return;
    }

    num = num * 10 + root.val;
    if (root.left == null && root.right == null) {
      sum += num;
    }

    helperB(root.left, num);
    helperB(root.right, num);
  }
}
