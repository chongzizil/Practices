package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

/**
 * Created by youlongli on 2/11/15.
 */
public class ValidateBinarySearchTree {
  private class Result {
    boolean isBST;
    public int min;
    public int max;
    public Result() {
      this.isBST = true;
      this.min = Integer.MAX_VALUE;
      this.max = Integer.MIN_VALUE;
    }
  }

  public boolean isValidBST(TreeNode root) {
    Result res = helper(root);
    return res.isBST;
  }

  private Result helper(TreeNode node) {
    Result res = new Result();
    if (node == null) {
      return res;
    }

    Result left = helper(node.left);
    Result right = helper(node.right);

    if (!left.isBST || !right.isBST) {
      res.isBST = false;
      return res;
    }

    // NOTE: Need to check if the child is null, because the node itself might has MAX or MIN value.
    if (node.left != null && left.max >= node.val) {
      res.isBST = false;
      return res;
    }

    if (node.right != null && right.min <= node.val) {
      res.isBST = false;
      return res;
    }

    res.max = Math.max(right.max, node.val);
    res.min = Math.min(left.min, node.val);

    return res;
  }
}
