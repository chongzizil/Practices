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
   * Use a wrapper class
   */
  class Result {
    int sum;
    public Result() {
      sum = 0;
    }
  }

  public int sumNumbersB(TreeNode root) {
    Result res = new Result();

    helperB(root, 0, res);

    return res.sum;
  }

  private void helperB(TreeNode node, int sum, Result res) {
    if (node == null) {
      return;
    }

    sum = sum * 10 + node.val;
    if (node.left == null && node.right == null) {
      res.sum += sum;
    }

    helperB(node.left, sum, res);
    helperB(node.right, sum, res);
  }

  /**
   * Store the result as global variable
   */
  private int sum = 0;

  public int solutionC(TreeNode root) {
    helperC(root, 0);

    return sum;
  }

  public void helperC(TreeNode root, int num) {
    if (root == null) {
      return;
    }

    num = num * 10 + root.val;
    if (root.left == null && root.right == null) {
      sum += num;
    }

    helperC(root.left, num);
    helperC(root.right, num);
  }
}
