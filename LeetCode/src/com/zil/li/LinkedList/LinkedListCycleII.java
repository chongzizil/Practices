package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/5/15.
 *
 * https://oj.leetcode.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public ListNode detectCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        break;
      }
    }

    if (fast == null || fast.next == null) {
      return null;
    }

    slow = head;

    while (slow != fast) {
      fast = fast.next;
      slow = slow.next;
    }

    return slow;
  }
}
