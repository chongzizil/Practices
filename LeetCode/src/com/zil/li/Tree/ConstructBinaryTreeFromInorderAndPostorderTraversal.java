package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

/**
 * Created by youlongli on 3/5/15.
 *
 * https://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * Idea: same as another problem...
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (postorder == null || inorder == null || postorder.length == 0 || postorder.length != inorder.length) {
      return null;
    }

    int n = inorder.length;
    return helper(inorder, postorder, 0, n - 1, 0, n - 1);
  }

  private TreeNode helper(int[] inorder, int[] postorder, int iBeg, int iEnd, int pBeg, int pEnd) {
    if (pBeg > pEnd) {
      return null;
    }

    TreeNode root = new TreeNode(postorder[pEnd]);
    int pos = find(inorder, postorder[pEnd], iBeg, iEnd);
    int leftNum = pos - iBeg;

    root.left = helper(inorder, postorder, iBeg, pos - 1, pBeg, pBeg + leftNum - 1);
    root.right = helper(inorder, postorder, pos + 1, iEnd, pBeg + leftNum, pEnd - 1);

    return root;
  }

  private int find(int[] inorder, int target, int iBeg, int iEnd) {
    for (int i = iBeg; i <= iEnd; i++) {
      if (inorder[i] == target) {
        return i;
      }
    }

    return -1;
  }
}
