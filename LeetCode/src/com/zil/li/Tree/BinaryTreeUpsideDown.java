package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by youlongli on 2/10/15.
 *
 * Idea: Each level will have one or two nodes.
 * If there's a left node, there will be either one left node or no node on the right.
 * For root, it will become the right node of its left node, and if the left node exist, will be the right node's left node.
 */
public class BinaryTreeUpsideDown {
  /**
   * Recursive solution. The new root will be the leftmost chile node. Draw the tree will help to understand it.
   * runtime: 252 ms
   */
  public TreeNode solutionA(TreeNode root) {
    if (root == null) {
      return null;
    }

    TreeNode newRoot = root;
    while (newRoot.left != null) {
      newRoot = newRoot.left;
    }

    helper(root);

    return newRoot;
  }

  private TreeNode helper(TreeNode root) {
    if (root == null) {
      return null;
    }
    if (root.left == null && root.right == null) {
      return root;
    }

    TreeNode parent = helper(root.left);
    parent.left = root.right;
    parent.right = root;
    root.left = null;
    root.right = null;

    return parent.right;
  }

  /**
   * Iterative solution.
   *
   * runtime: 261 ms
   */
  public TreeNode solutionB(TreeNode root) {
    Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
    List<List<TreeNode>> levels = new ArrayList<List<TreeNode>>();
    TreeNode res = null;

    if (root == null) {
      return res;
    }

    queue.addLast(root);

    while (!queue.isEmpty()) {
      List<TreeNode> level = new ArrayList<TreeNode>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.pollFirst();
        if (node.left != null) {
          queue.addLast(node.left);
          node.left = null;
        }
        if (node.right != null) {
          queue.addLast(node.right);
          node.right = null;
        }
        level.add(node);
      }
      levels.add(level);
    }

    List<TreeNode> lastLevel = levels.get(levels.size() - 1);
    res = lastLevel.get(0);

    for (int i = levels.size() - 1; i > 0; i--) {
      List<TreeNode> level = levels.get(i);
      List<TreeNode> nextLevel = levels.get(i - 1);
      TreeNode r = level.get(0);

      if (level.size() == 2) {
        r.left = level.get(1);
      }
      r.right = nextLevel.get(0);
    }

    return res;
  }
}
