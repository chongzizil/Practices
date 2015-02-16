package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;
import com.zil.li.datastructure.TreeNode;

/**
 * Created by youlongli on 2/15/15.
 *
 * https://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertSortedListToBinarySearchTree {
  private ListNode curr;

  public TreeNode solutionA(ListNode head) {
    int size = getSize(head);

    curr = head;
    TreeNode res = helperA(size);

    return res;
  }

  private int getSize(ListNode head) {
    int size = 0;
    while (head != null) {
      size++;
      head = head.next;
    }
    return size;
  }

  private TreeNode helperA(int size) {
    if (size <= 0) {
      return null;
    }

    TreeNode left = helperA(size / 2);

    TreeNode root = new TreeNode(curr.val);
    curr = curr.next;

    TreeNode right = helperA(size - size / 2 - 1);

    root.left = left;
    root.right = right;

    return root;
  }
}
