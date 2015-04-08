package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by youlongli on 2/9/15.
 *
 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {
  /**
   * BFS: Use queue.
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public List<List<Integer>> levelOrderA(TreeNode root) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    Deque<TreeNode> queue = new ArrayDeque<TreeNode>();

    if (root == null) {
      return res;
    }

    queue.addLast(root);

    while (!queue.isEmpty()) {
      List<Integer> tmp = new ArrayList<Integer>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.pollFirst();
        tmp.add(node.val);
        if (node.left != null) {
          queue.addLast(node.left);
        }
        if (node.right != null) {
          queue.addLast(node.right);
        }
      }

      res.add(tmp);
    }

    return res;
  }

  /**
   * DFS: Use recursive function.
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public List<List<Integer>> levelOrderB(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    int currLevel = 0;

    dfs(res, root, 0);

    return res;
  }

  private void dfs(List<List<Integer>> res, TreeNode node, int currLevel) { // In-order
    if (node == null) {
      return;
    }

    if (res.size() < currLevel + 1) {
      res.add(new ArrayList<Integer>());
    }

    res.get(currLevel).add(node.val);

    dfs(res, node.left, currLevel + 1);
    dfs(res, node.right, currLevel + 1);
  }
}
