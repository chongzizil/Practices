package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/15/15.
 *
 * https://oj.leetcode.com/problems/partition-list/
 */
public class PartitionList {
  /**
   * More concise one, clean the tail at the last.
   */
  public ListNode solutionA(ListNode head, int x) {
    ListNode small = new ListNode(0);
    ListNode currS = small;
    ListNode large = new ListNode(0);
    ListNode currL = large;

    while (head != null) {
      if (head.val < x) {
        currS.next = head;
        currS = currS.next;
      } else {
        currL.next = head;
        currL = currL.next;
      }
      head = head.next;
    }

    currL.next = null;
    currS.next = large.next;
    return small.next;
  }

  public ListNode solutionB(ListNode head, int x) {
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
