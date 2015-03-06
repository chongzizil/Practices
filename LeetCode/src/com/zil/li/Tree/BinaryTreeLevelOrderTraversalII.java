package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by youlongli on 2/8/15.
 *
 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class BinaryTreeLevelOrderTraversalII {
  /**
   * runtime: 270 ms
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
      res.add(level);
    }

    // Reverse the list...
    reverseList(res);

    return res;
  }

  private void reverseList(List<List<Integer>> res) {
    for (int i = 0, j = res.size() - 1; i < j; i++, j--) {
      List<Integer> tmpLevel = res.get(i);
      res.set(i, res.get(j));
      res.set(j, tmpLevel);
    }
  }
}
