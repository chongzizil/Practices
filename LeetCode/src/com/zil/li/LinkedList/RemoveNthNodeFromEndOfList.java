package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/5/15.
 *
 * https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
      return null;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode end = dummy;
    ListNode prev = dummy;

    // Assume n is a legal input.
    for (int i = 0; i < n; i++) {
      end = end.next;
    }

    while (end.next != null) {
      prev = prev.next;
      end = end.next;
    }

    prev.next = prev.next.next;
    return dummy.next;
  }
}
