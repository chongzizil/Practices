package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/15/15.
 *
 * https://oj.leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k <= 1) {
      return head;
    }

    int len = getLength(head);
    int num = len / k;

    // K might be larger than the length of the list
    if (num == 0) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    ListNode res = dummy;

    // Get the new head first
    for (int i = 0; i < k; i++) {
      res = res.next;
    }

    // Reverse each group
    for (int i = 0; i < num; i++) {
      ListNode post = prev;
      for (int j = 0; j < k + 1; j++) {
        post = post.next;
      }
      prev = reverse(prev, post);
    }

    return res;
  }

  // Reverse all the nodes between prev and post, then return the tail node
  private ListNode reverse(ListNode prev, ListNode post) {
    ListNode curr = prev.next;
    while (curr.next != post) {
      ListNode next = curr.next;
      curr.next = next.next;
      next.next = prev.next;
      prev.next = next;
    }
    return curr;
  }

  private int getLength(ListNode head) {
    int len = 0;
    while (head != null) {
      len++;
      head = head.next;
    }
    return len;
  }
}
