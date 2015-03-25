package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/15/15.
 *
 * https://oj.leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k <= 1) {
      return head; // Note: return head instead of null since we also check k == 1 which means no node will be reversed.
    }

    int len = getLen(head);
    int numOfGroup = len / k;

    if (numOfGroup == 0) {
      return head; // Note: must return if group number == 0, otherwise the newHead will throw null pointer exception.
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;

    for (int i = 0; i < numOfGroup; i++) {
      ListNode post = prev; // update post node first
      for (int j = 0; j < k + 1; j++) {
        post = post.next;
      }
      prev = reverse(prev, post);
    }

    return dummy.next;
  }

  private int getLen(ListNode head) {
    int len = 0;
    while (head != null) {
      len++;
      head = head.next;
    }
    return len;
  }

  private ListNode reverse(ListNode prev, ListNode post) {
    ListNode curr = prev.next;
    while (curr.next != post) {
      ListNode next = curr.next;
      curr.next = next.next;
      next.next = prev.next;
      prev.next = next;
    }
    return curr;
  }
}
