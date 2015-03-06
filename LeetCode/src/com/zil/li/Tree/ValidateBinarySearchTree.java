package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

/**
 * Created by youlongli on 2/11/15.
 */
public class ValidateBinarySearchTree {
  private class Result {
    boolean isValid;
    public int min;
    public int max;
    public Result() {
      this.isValid = true;
      this.min = Integer.MAX_VALUE;
      this.max = Integer.MIN_VALUE;
    }
  }

  public boolean isValidBST(TreeNode root) {
    Result res = helper(root);
    return res.isValid;
  }

  private Result helper(TreeNode root) {
    Result res = new Result();
    if (root == null) {
      return res;
    }

    Result left = helper(root.left);
    Result right = helper(root.right);

    if (!left.isValid || !right.isValid) {
      res.isValid = false;
      return res;
    }

    // NOTE: Need to check if the child is null, because the node itself might has MAX or MIN value.
    if (root.left != null && left.max >= root.val) {
      res.isValid = false;
      return res;
    }

    if (root.right != null && right.min <= root.val) {
      res.isValid = false;
      return res;
    }

    res.min = Math.min(left.min, root.val);
    res.max = Math.max(right.max, root.val);

    return res;
  }
}
