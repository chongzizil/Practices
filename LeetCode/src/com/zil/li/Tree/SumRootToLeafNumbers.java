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
    if (root == null) {
      return 0;
    }

    return helperA(root, 0);
  }

  private int helperA(TreeNode root, int num) {
    if (root == null) {
      return 0;
    }
    int newNum = num * 10 + root.val;
    if (root.left == null && root.right == null) {
      return newNum;
    }
    return helperA(root.left, newNum) + helperA(root.right, newNum);
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
