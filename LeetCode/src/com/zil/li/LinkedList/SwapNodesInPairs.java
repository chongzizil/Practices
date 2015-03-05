package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/15/15.
 *
 * https://oj.leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;

    while (prev.next != null && prev.next.next != null) {
      // For simplicity
      ListNode curr = prev.next;
      ListNode next = curr.next;
      // Start reverse process
      curr.next = next.next;
      next.next = prev.next;
      prev.next = next;
      // prev = prev.next.next will do the job too.
      prev = curr;
    }

    return dummy.next;
  }
}
