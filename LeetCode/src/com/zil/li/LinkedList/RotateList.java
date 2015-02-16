package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/15/15.
 */
public class RotateList {
  public ListNode rotateRight(ListNode head, int n) {
    if (head == null) {
      return head;
    }

    int size = getSize(head);
    int k = n % size;

    if (k == 0) {
      return head;
    }

    ListNode fast = head;
    ListNode slow = head;

    for (int i = 0; i < k; i++) {
      fast = fast.next;
    }

    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    fast.next = head;
    head = slow.next;
    slow.next = null;

    return head;
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
