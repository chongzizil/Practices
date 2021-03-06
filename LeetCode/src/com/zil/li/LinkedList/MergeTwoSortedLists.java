package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/14/15.
 *
 * https://oj.leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
  /**
   * Time complexity: O(m + n)
   * Space complexity: O(1)
   */
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        curr.next = l1;
        l1 = l1.next;
      } else {
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;
    }

    if (l1 != null) {
      curr.next = l1;
    }

    if (l2 != null) {
      curr.next = l2;
    }

    return dummy.next;
  }
}
