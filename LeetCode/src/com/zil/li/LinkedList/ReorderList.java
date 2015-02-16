package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/5/15.
 */
public class ReorderList {
  public void reorderList(ListNode head) {
    ListNode curr = new ListNode(0);
    ListNode left = head;
    ListNode right;
    ListNode mid;

    if (head == null) {
      return;
    }

    mid = getMiddleNode(head);

    right = reverseNode(mid.next);

    mid.next = null;

    while (left != null && right != null) {
      curr.next = left;
      curr = curr.next;
      left = left.next;
      curr.next = right;
      curr = curr.next;
      right = right.next;
    }

    while (left != null) {
      curr.next = left;
      curr = curr.next;
      left = left.next;
    }
  }

  private ListNode getMiddleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  private ListNode reverseNode(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode curr = head;

    while (curr.next != null) {
      ListNode next = curr.next;
      curr.next = next.next;
      next.next = dummy.next;
      dummy.next = next;
    }

    return dummy.next;
  }
}
