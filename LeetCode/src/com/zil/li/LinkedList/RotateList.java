package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/15/15.
 *
 * https://oj.leetcode.com/problems/rotate-list/
 */
public class RotateList {
  public ListNode rotateRight(ListNode head, int n) {
    if (head == null) {
      return null;
    }

    int size = getSize(head);
    n = n % size;

    if (n == 0) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode fast = dummy;
    ListNode slow = dummy;

    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }

    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    // Fast will point to the old tail
    // Slow will point to the new tail and its next node will be the new head
    fast.next = dummy.next;
    dummy.next = slow.next;
    slow.next = null;

    return dummy.next;
  }

  private int getSize(ListNode head) {
    int size = 0;
    while (head != null) {
      size++;
      head = head.next;
    }
    return size;
  }
}
