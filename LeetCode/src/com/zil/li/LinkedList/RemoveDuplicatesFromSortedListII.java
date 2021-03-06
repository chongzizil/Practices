package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/15/15.
 *
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesFromSortedListII {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode curr = dummy; // Points to a valid node (With no duplicates.)

    while (curr != null) {
      // If next two nodes are duplicates, record value and start skipping...
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
