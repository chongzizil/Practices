package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/5/15.
 */
public class IntersectionOfTwoLinkedLists {
  /**
   * The idea: If two linked list have intersection node, this means start from that node, the length of the rest of the list is same.
   * So in order to find out that if such a node exists, I calculate the length of both list first, and for the longer one, I need to
   * skip (abs(lenA - lenB)) nodes. Then I can simply check each next node of A and B, if no intersection exists, then one of them
   * will be null...
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }

    int lenA = getListLength(headA);
    int lenB = getListLength(headB);
    int step = Math.abs(lenA - lenB);

    ListNode currA = headA;
    ListNode currB = headB;

    for (int i = 0; i < step; i++) {
      if (lenA > lenB) {
        currA = currA.next;
      } else {
        currB = currB.next;
      }
    }

    while (currA != null && currB != null) {
      if (currA.val == currB.val) {
        return currA;
      }

      currA = currA.next;
      currB = currB.next;
    }

    return null;
  }

  private int getListLength(ListNode head) {
    int length = 0;
    while (head != null) {
      head = head.next;
      length++;
    }
    return length;
  }
}
