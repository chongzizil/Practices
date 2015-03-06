package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;

/**
 * Created by youlongli on 2/10/15.
 *
 * https://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertSortedArrayToBinarySearchTree {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public TreeNode sortedArrayToBST(int[] num) {
    if (num == null) {
      return null;
    }

    return helper(num, 0, num.length - 1);
  }

  private TreeNode helper(int[] num, int l, int r) {
    if (l > r) {
      return null;
    }

    int mid = l + (r - l) / 2;
    TreeNode left = helper(num, l, mid - 1);
    TreeNode right = helper(num, mid + 1, r);

    TreeNode root = new TreeNode(num[mid]);
    root.left = left;
    root.right = right;

    return root;
  }
}
