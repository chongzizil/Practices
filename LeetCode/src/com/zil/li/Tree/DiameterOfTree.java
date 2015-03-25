package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

/**
 * Created by youlongli on 3/13/15.
 */
public class DiameterOfTree {
  private class Result {
    int maxD;
    int maxH;
    public Result() {
      maxD = Integer.MIN_VALUE;
      maxH = Integer.MIN_VALUE;
    }
  }

  public int getDiameter(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return helper(root).maxD;
  }

  private Result helper(TreeNode node) {
    Result result = new Result();
    if (node == null) {
      return result;
    }

    Result lRes = helper(node.left);
    Result rRes = helper(node.right);

    int cross = lRes.maxH + rRes.maxH + 1;

    result.maxH = Math.max(lRes.maxH, rRes.maxH) + 1;
    result.maxD = Math.max(cross, Math.max(lRes.maxD, rRes.maxD));

    return result;
  }
}
