package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

/**
 * Created by youlongli on 3/11/15.
 *
 * http://www.lintcode.com/en/problem/lowest-common-ancestor/
 *
 * Idea: Use recursive function, if a node is not found, return null. Otherwise
 * return the node itself. If for a node, it's left and right child both return not null result,
 * then this node is the lowest common ancestor.
 */
public class LowestCommonAncestor {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
    if (root == null) {
      return null;
    }

    if (root.equals(A) || root.equals(B)) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, A, B);
    TreeNode right = lowestCommonAncestor(root.right, A, B);

    // This node is the lowest common ancestor.
    if (left != null && right != null) {
      return root;
    }

    // One of the node if the left, return that node.
    if (left != null) {
      return left;
    }

    return right;
  }
}
