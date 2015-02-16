package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by youlongli on 2/10/15.
 *
 * https://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {
  public List<Integer> solution(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

    if (root == null) {
      return res;
    }

    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      res.add(node.val);

      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }

    return res;
  }
}
