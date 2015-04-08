package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by youlongli on 4/5/15.
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {
  /**
   * Use BFS to traverse each level, and only record the last element of each level.
   */
  public List<Integer> rightSideViewA(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();

    if (root == null) {
      return res;
    }

    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }

        if (i == size - 1) {
          // The is the right side view element
          res.add(node.val);
        }
      }
    }

    return res;
  }

  /**
   * Use DFS and go the right node first if it's possible, hence the first node for a level will be the right side view node.
   */
  public List<Integer> rightSideViewB(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    dfs(res, root, 0);

    return res;
  }

  private void dfs(List<Integer> res, TreeNode node, int level) {
    if (node == null) {
      return;
    }

    if (res.size() < level + 1) {
      // First node found!
      res.add(node.val);
    }

    // Check the right child first!
    dfs(res, node.right, level + 1);
    dfs(res, node.left, level + 1);
  }
}
