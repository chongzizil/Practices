package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by youlongli on 2/11/15.
 */
public class BinaryTreePostorderTraversal {
  /**
   * http://www.youtube.com/watch?v=hv-mJUs5mvU
   */
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
    Deque<TreeNode> output = new ArrayDeque<TreeNode>();

    if (root == null) {
      return res;
    }

    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      output.push(node);

      if (node.left != null) {
        stack.push(node.left);
      }
      if (node.right != null) {
        stack.push(node.right);
      }
    }

    while (!output.isEmpty()) {
      res.add(output.pop().val);
    }

    return res;
  }
}
