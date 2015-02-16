package com.zil.li.DP;

import com.zil.li.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 2/10/15.
 *
 * https://oj.leetcode.com/problems/unique-binary-search-trees-ii/
 *
 * Idea: For each number as the root, generate all possible left subtree and right subtree.
 */
public class UniqueBinarySearchTreesII {
  public List<TreeNode> generateTrees(int n) {
    return helper(1, n);
  }

  private List<TreeNode> helper(int start, int end) {
    List<TreeNode> res = new ArrayList<TreeNode>();

    if (start > end) {
      res.add(null);
    }

    for (int i = start; i <= end; i++) {
      List<TreeNode> leftTrees = helper(start, i - 1);
      List<TreeNode> rightTrees = helper(i + 1, end);
      for (TreeNode leftTree : leftTrees) {
        for (TreeNode rightTree : rightTrees) {
          TreeNode root = new TreeNode(i);
          root.left = leftTree;
          root.right = rightTree;
          res.add(root);
        }
      }
    }

    return res;
  }
}
