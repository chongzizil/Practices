package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by youlongli on 2/10/15.
 *
 * https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {
  /**
   * This one is much concise and use less space.
   */
  public List<Integer> solutionA(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
    TreeNode curr = root;

    while (true) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }

      if (stack.isEmpty()) {
        break;
      }

      curr = stack.pop();
      res.add(curr.val);
      curr = curr.right;
    }

    return res;
  }

  public List<Integer> solutionB(TreeNode root) {
    Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
    List<TreeNode> visited = new ArrayList<TreeNode>();
    List<Integer> res = new ArrayList<Integer>();

    if (root == null) {
      return res;
    }

    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode node = stack.peek();
      if (!visited.contains(node) && node.left != null) {
        stack.push(node.left);
        visited.add(node);
      } else {
        node = stack.pop();
        res.add(node.val);
        if (node.right != null) {
          stack.push(node.right);
        }
      }
    }

    return res;
  }
}
