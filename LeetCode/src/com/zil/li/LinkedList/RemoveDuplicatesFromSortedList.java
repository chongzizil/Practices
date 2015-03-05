package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/5/15.
 *
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode curr = head;

    // Just need to check the next for duplicates
    while (curr.next != null) {
      if (curr.val == curr.next.val) {
        curr.next = curr.next.next; // Remove duplicate
      } else {
        curr = curr.next; // Move forward
      }
    }

    return head;
  }
}
