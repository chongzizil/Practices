package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/5/15.
 *
 * https://oj.leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public boolean hasCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      // I think instead of fast == slow, this should be more proper... (equals() can not pass the cases...)
      if (fast != null && fast.val == slow.val) {
        return true;
      }
    }

    return false;
  }
}
