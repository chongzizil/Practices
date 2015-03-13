package com.zil.li.template;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/4/15.
 */
public class LinkedListT {
  /**
   * This function get the (2 / n) + 1 node.
   */
  public ListNode getMiddleA(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  /**
   * This function finds the middle node where we need to divide the list into two parts...
   */
  public ListNode getMiddleB(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode slow = head;
    ListNode fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  public ListNode reverse(ListNode head) {
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

  public void reverse(ListNode preNode, ListNode postNode) {
    ListNode curr = preNode.next;

    while (curr.next != postNode) {
      ListNode next = curr.next;
      curr.next = next.next;
      next.next = preNode.next;
      preNode.next = next;
    }
  }
}
