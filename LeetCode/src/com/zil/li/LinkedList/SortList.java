package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

/**
 * Created by youlongli on 2/15/15.
 *
 * https://oj.leetcode.com/problems/sort-list/
 */
public class SortList {
  /**
   * Merge sort.
   * Time complexity: O(nlogn)
   * Space complexity: O(1)
   */
  public ListNode solutionA(ListNode head) {
    return mergeSort(head);
  }

  private ListNode mergeSort(ListNode head) {
    // Note: Return null if the list is null or the list only has one node.
    if (head == null || head.next == null) {
      return head;
    }

    ListNode mid = getMiddle(head);
    ListNode left = head;
    ListNode right = mid.next;
    mid.next = null;
    left = mergeSort(left);
    right = mergeSort(right);
    head = merge(left, right);

    return head;
  }

  private ListNode merge(ListNode left, ListNode right) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    while (left != null && right != null) {
      if (left.val < right.val) {
        curr.next = left;
        left = left.next;
      } else {
        curr.next = right;
        right = right.next;
      }
      curr = curr.next;
    }

    if (left != null) {
      curr.next = left;
    }
    if (right != null) {
      curr.next = right;
    }

    return dummy.next;
  }

  private ListNode getMiddle(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode fast = head.next;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    return slow;
  }
}
