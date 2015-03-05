package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/5/15.
 *
 * https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * The idea: If two linked list have intersection node, this means start from that node, the length of the rest of the list is same.
 * So in order to find out that if such a node exists, I calculate the length of both list first, and for the longer one, I need to
 * skip (abs(lenA - lenB)) nodes. Then I can simply check each next node of A and B, if no intersection exists, then one of them
 * will be null...
 */
public class IntersectionOfTwoLinkedLists {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }

    int lenA = getLen(headA);
    int lenB = getLen(headB);
    int diff = Math.abs(lenA - lenB);

    for (int i = 0; i < diff; i++) {
      if (lenA > lenB) {
        headA = headA.next;
      } else {
        headB = headB.next;
      }
    }

    while (headA != null && headB != null) {
      if (headA.val == headB.val) {
        return headA; // Found
      }
      headA = headA.next;
      headB = headB.next;
    }

    return null; // Not found
  }

  private int getLen(ListNode head) {
    int len = 0;
    while (head != null) {
      len++;
      head = head.next;
    }
    return len;
  }
}
