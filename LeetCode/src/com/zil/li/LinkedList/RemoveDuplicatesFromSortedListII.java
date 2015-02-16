package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/15/15.
 */
public class RemoveDuplicatesFromSortedListII {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode curr = dummy;

    while (curr != null) {
      if (curr.next != null && curr.next.next != null && curr.next.val == curr.next.next.val) {
        int val = curr.next.val;
        while (curr.next != null && curr.next.val == val) {
          curr.next = curr.next.next;
        }
      } else {
        curr = curr.next;
      }
    }

    return dummy.next;
  }
}
