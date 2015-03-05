package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/5/15.
 */
public class ReverseLinkedListII {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null) {
      return null;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode prev = dummy;
    ListNode post = dummy;

    // Assume 1 <= m <= n <= length of the list
    for (int i = 0; i < m - 1; i++) {
      prev = prev.next;
    }

    for (int j = 0; j < n + 1; j++) {
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
