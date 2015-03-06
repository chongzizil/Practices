package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by youlongli on 2/11/15.
 *
 * https://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigzagLevelOrderTraversal {
  /**
   * Time complexity: O(n)
   * Space complexity: O(n)
   */
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    Deque<TreeNode> queue = new ArrayDeque<TreeNode>();

    if (root == null) {
      return res;
    }

    queue.addLast(root);

    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<Integer>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.pollFirst();
        level.add(node.val);
        if (node.left != null) {
          queue.addLast(node.left);
        }
        if (node.right != null) {
          queue.addLast(node.right);
        }
      }

      // If the levels added is odd number, reverse the new level list.
      if (res.size() % 2 != 0) {
        reverse(level);
      }

      res.add(level);
    }

    return res;
  }

  private void reverse(List<Integer> list) {
    for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
      int tmp = list.get(i);
      list.set(i, list.get(j));
      list.set(j, tmp);
    }
  }
}
