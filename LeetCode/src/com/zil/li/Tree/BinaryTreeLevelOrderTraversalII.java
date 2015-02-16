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
   * runtime: 264 ms
   */
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> tmp = new ArrayList<List<Integer>>();
    Deque<TreeNode> queue = new ArrayDeque<TreeNode>();

    if (root == null) {
      return tmp;
    }

    queue.addLast(root);

    while (!queue.isEmpty()) {
      List<Integer> tmpList = new ArrayList<Integer>();
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.pollFirst();
        tmpList.add(node.val);
        if (node.left != null) {
          queue.addLast(node.left);
        }
        if (node.right != null) {
          queue.addLast(node.right);
        }
      }

      tmp.add(tmpList);
    }

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    for (int i = tmp.size() - 1; i >= 0; i--) {
      res.add(tmp.get(i));
    }

    return res;
  }


}
