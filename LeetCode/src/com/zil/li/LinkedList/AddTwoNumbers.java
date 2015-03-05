package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/15/15.
 *
 * https://oj.leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
  /**
   * Time complexity: O(n)
   * Space complexity: O(n)
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    int carry = 0;

    while (l1 != null && l2 != null) {
      int sum = l1.val + l2.val + carry;
      int digit = sum % 10;
      carry = sum / 10;
      ListNode node = new ListNode(digit);
      curr.next = node;
      curr = curr.next;

      l1 = l1.next;
      l2 = l2.next;
    }

    // Note: Use while loop... Don't be careless
    while (l1 != null) {
      int sum = l1.val + carry;
      int digit = sum % 10;
      carry = sum / 10;
      ListNode node = new ListNode(digit);
      curr.next = node;
      curr = curr.next;

      l1 = l1.next;
    }

    while (l2 != null) {
      int sum = l2.val + carry;
      int digit = sum % 10;
      carry = sum / 10;
      ListNode node = new ListNode(digit);
      curr.next = node;
      curr = curr.next;

      l2 = l2.next;
    }

    if (carry != 0) {
      ListNode node = new ListNode(carry);
      curr.next = node;
    }

    return dummy.next;
  }
}
