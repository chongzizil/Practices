package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlongli on 2/10/15.
 *
 * https://oj.leetcode.com/problems/path-sum-ii/
 *
 * Idea: Use backtracking...
 */
public class PathSumII {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();

    dfs(res, list, root, sum);

    return res;
  }

  private void dfs(List<List<Integer>> res, List<Integer> list, TreeNode node, int restSum) {
    if (node == null) {
      return;
    }

    list.add(node.val);
    if (node.left == null && node.right == null && node.val == restSum) {
      res.add(new ArrayList<Integer>(list)); // Note: copy the list!
    }

    dfs(res, list, node.left, restSum - node.val);
    dfs(res, list, node.right, restSum - node.val);
    list.remove(list.size() - 1);
  }
}
