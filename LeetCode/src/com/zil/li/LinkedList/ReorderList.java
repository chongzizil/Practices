package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/5/15.
 */
public class ReorderList {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }

    ListNode l = head;
    ListNode mid = getMiddle(head); // Mid is the last node of left part
    ListNode r = reverse(mid); // Mid passes in as the prev node.
    mid.next = null;

    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    while (l != null && r != null) {
      curr.next = l;
      curr = curr.next;
      l = l.next;

      curr.next = r;
      curr = curr.next;
      r = r.next;
    }

    curr.next = l; // Append l anyway, it's either null or a single node.
  }

  private ListNode reverse(ListNode prev) {
    ListNode curr = prev.next;
    while (curr.next != null) {
      ListNode next = curr.next;
      curr.next = next.next;
      next.next = prev.next;
      prev.next = next;
    }
    return prev.next;
  }

  private ListNode getMiddle(ListNode head) {
    ListNode fast = head.next; // Already make sure head.next != null at start
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}
