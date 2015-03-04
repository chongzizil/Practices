package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/5/15.
 *
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode curr = head;

    while (curr.next != null) {
      if (curr.val == curr.next.val) {
        curr.next = curr.next.next;
      } else {
        curr = curr.next;
      }
    }

    return head;
  }
}
