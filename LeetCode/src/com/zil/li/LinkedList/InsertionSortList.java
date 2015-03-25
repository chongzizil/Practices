package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/15/15.
 *
 * https://oj.leetcode.com/problems/insertion-sort-list/
 */
public class InsertionSortList {
  /**
   * Time complexity: O(n^2)
   * Space complexity: O(1)
   */
  public ListNode solution(ListNode head) {
    ListNode dummy = new ListNode(0);

    while (head != null) {
      ListNode curr = dummy;
      while (curr.next != null && curr.next.val < head.val) { // Check the right since curr is the prev node
        curr = curr.next;
      }
      ListNode tmp = curr.next;
      curr.next = head;
      head = head.next; // Note: First set the head to be the next, then set the curr.next.next!
      // Curr.next can not be head.next. Need to append the tail since it's insertion sort.
      curr.next.next = tmp; // Note: it's next.next
    }

    return dummy.next;
  }
}
