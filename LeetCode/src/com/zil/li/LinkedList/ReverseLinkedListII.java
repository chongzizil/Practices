package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/5/15.
 */
public class ReverseLinkedListII {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode prev = dummy;
    ListNode post = dummy;

    for (int i = 0; i < m - 1; i++) {
      prev = prev.next;
    }
    for (int i = 0; i < n + 1; i++) {
      post = post.next;
    }

    reverse(prev, post);
    return dummy.next;
  }

  private void reverse(ListNode prev, ListNode post) {
    ListNode curr = prev.next;

    while (curr.next != post) {
      ListNode next = curr.next;
      curr.next = next.next;
      next.next = prev.next;
      prev.next = next;
    }
  }
}
