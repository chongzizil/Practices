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
   *
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public ListNode solutionA(ListNode head, int x) {
    ListNode leftDummy = new ListNode(0);
    ListNode rightDummy = new ListNode(0);
    ListNode leftCurr = leftDummy;
    ListNode rightCurr = rightDummy;

    while (head != null) {
      if (head.val < x) {
        leftCurr.next = head;
        leftCurr = leftCurr.next;
      } else {
        rightCurr.next = head;
        rightCurr = rightCurr.next;
      }
      head = head.next; // Note: Do not forget to move the head...
    }

    leftCurr.next = rightDummy.next;
    rightCurr.next = null;

    return leftDummy.next;
  }
}
