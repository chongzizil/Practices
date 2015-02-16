package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/15/15.
 *
 * https://oj.leetcode.com/problems/partition-list/
 */
public class PartitionList {
  public ListNode partition(ListNode head, int x) {
    ListNode small = new ListNode(0);
    ListNode large = new ListNode(0);
    ListNode currSmall = small;
    ListNode currLarge = large;
    ListNode curr = head;

    while (curr != null) {
      if (curr.val < x) {
        currSmall.next = curr;
        curr = curr.next;
        currSmall = currSmall.next;
        currSmall.next = null;
      } else {
        currLarge.next = curr;
        curr = curr.next;
        currLarge = currLarge.next;
        currLarge.next = null;
      }
    }

    currSmall.next = large.next;
    return small.next;
  }
}
