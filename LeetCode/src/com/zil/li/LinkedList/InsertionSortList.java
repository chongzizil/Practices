package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/15/15.
 */
public class InsertionSortList {
  public ListNode insertionSortList(ListNode head) {
    ListNode dummy = new ListNode(0);
    ListNode curr = head;

    while (curr != null) {
      ListNode node = dummy;
      while (node.next != null && node.next.val < curr.val) {
        node = node.next;
      }
      ListNode tmp = node.next;
      node.next = curr;
      curr = curr.next;
      node.next.next = tmp;
    }

    return dummy.next;
  }
}
