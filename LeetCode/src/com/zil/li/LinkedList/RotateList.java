package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/15/15.
 *
 * https://oj.leetcode.com/problems/rotate-list/
 */
public class RotateList {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return head;
    }

    int len = getLen(head);
    k = k % len;

    if (k == 0) {
      return head; // Note: Return the head
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode prev = dummy; // new tail
    ListNode end = dummy; // connect node

    for (int i = 0; i < k; i++) {
      end = end.next;
    }

    while (end.next != null) {
      prev = prev.next;
      end = end.next;
    }

    end.next = dummy.next; // connect
    dummy.next = prev.next; // new head
    prev.next = null; // new tail

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
}
