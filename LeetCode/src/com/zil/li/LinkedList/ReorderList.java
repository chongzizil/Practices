package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/5/15.
 */
public class ReorderList {
  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }

    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    ListNode l = head;
    ListNode mid = getMiddle(head);
    ListNode r = reverse(mid.next);
    mid.next = null;

    while (l != null && r != null) {
      curr.next = l;
      l = l.next;
      curr = curr.next;

      curr.next = r;
      r = r.next;
      curr = curr.next;
    }

    // Left part will have the same number or one more node than the right part.
    if (l != null) {
      curr.next = l;
    }
  }

  // Return the middle node, which is the last node of the left part
  private ListNode getMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    return slow;
  }

  private ListNode reverse(ListNode head) {
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
