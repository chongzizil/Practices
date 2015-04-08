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
    if (preorder == null || inorder == null || preorder.length != inorder.length) {
      return null;
    }

    int n = preorder.length;

    return helper(preorder, inorder, 0, n - 1, 0, n - 1);
  }

  private TreeNode helper(int[] preorder, int[] inorder, int begP, int endP, int begI, int endI) {
    if (begP > endP) {
      return null;
    }

    TreeNode root = new TreeNode(preorder[begP]);
    int index = searchElem(inorder, begI, endI, root.val);
    int leftNum = index - begI;

    root.left = helper(preorder, inorder, begP + 1, begP + leftNum, begI, index - 1);
    root.right = helper(preorder, inorder, begP + leftNum + 1, endP, index + 1, endI);

    return root;
  }

  private int searchElem(int[] array, int beg, int end, int target) { // No binary search, it's not sorted.
    for (int i = beg; i <= end; i++) {
      if (array[i] == target) {
        return i;
      }
    }

    throw new IllegalArgumentException("Oooops...");
  }
}
