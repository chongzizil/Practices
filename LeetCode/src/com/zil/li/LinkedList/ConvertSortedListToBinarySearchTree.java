package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;
import com.zil.li.datastructure.TreeNode;

/**
 * Created by youlongli on 2/15/15.
 *
 * https://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertSortedListToBinarySearchTree {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  ListNode curr; // It's not a good idea, but it does the job.
  public TreeNode solutionA(ListNode head) {
    int len = getLen(head);
    curr = head;

    return generateBST(len);
  }

  private TreeNode generateBST(int len) {
    if (len <= 0) {
      return null;
    }

    TreeNode left = generateBST(len / 2);

    TreeNode root = new TreeNode(curr.val);
    curr = curr.next;

    TreeNode right = generateBST(len - len / 2 - 1);

    root.left = left;
    root.right = right;

    return root;
  }

  private int getLen(ListNode head) {
    int len = 0;
    while (head != null) {
      len++;
      head = head.next;
    }
    return len;
  }

  /**
   * Not much different, this one use two pointer l and r instead of the len/num.
   */
  public TreeNode solutionB(ListNode head) {
    curr = head;
    int len = getLen(head);

    return helper(0, len - 1);
  }

  private TreeNode helper(int l, int r) {
    if (l > r) {
      return null;
    }

    int mid = l + (r - l) / 2;
    TreeNode left = helper(l, mid - 1);
    TreeNode root = new TreeNode(curr.val);
    curr = curr.next;
    TreeNode right = helper(mid + 1, r);

    root.left = left;
    root.right = right;

    return root;
  }
}
