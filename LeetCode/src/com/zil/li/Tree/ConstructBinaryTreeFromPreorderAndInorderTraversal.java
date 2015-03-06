package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

/**
 * Created by youlongli on 3/5/15.
 *
 * https://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Idea:
 * http://www.cnblogs.com/yuzhangcmu/p/4199039.html
 * http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) {
      return null;
    }

    int len = inorder.length;
    return helper(preorder, inorder, 0, len - 1, 0, len - 1);
  }

  private TreeNode helper(int[] preorder, int[] inorder, int pBeg, int pEnd, int iBeg, int iEnd) {
    if (pBeg > pEnd) {
      return null;
    }

    TreeNode root = new TreeNode(preorder[pBeg]);

    int pos = find(inorder, preorder[pBeg], iBeg, iEnd);
    int leftNum = pos - iBeg; // Note: do not +1

    root.left = helper(preorder, inorder, pBeg + 1, pBeg + leftNum, iBeg, pos - 1);
    root.right = helper(preorder, inorder, pBeg + leftNum + 1, pEnd, pos + 1, iEnd);

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
