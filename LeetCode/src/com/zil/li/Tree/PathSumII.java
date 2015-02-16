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
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();

    helper(res, list, root, sum);

    return res;
  }

  private void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
    if (root == null) {
      return;
    }

    list.add(root.val);

    if (root.left == null && root.right == null && root.val == sum) {
      res.add(new ArrayList<Integer>(list));
    }

    helper(res, list, root.left, sum - root.val);
    helper(res, list, root.right, sum - root.val);

    list.remove(list.size() - 1);
  }
}
