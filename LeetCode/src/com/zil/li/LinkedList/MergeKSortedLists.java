package com.zil.li.LinkedList;

import com.zil.li.datastructure.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by youlongli on 2/15/15.
 *
 * https://oj.leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {
  /**
   * Time complexity: O(nklogk)
   * Space complexity: O(k)
   */
  public ListNode solutionA(List<ListNode> lists) {
    if (lists == null || lists.size() == 0) {
      return null;
    }

    Queue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
      public int compare(ListNode node1, ListNode node2) {
        return node1.val - node2.val;
      }
    });

    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    for (ListNode head : lists) {
      if (head != null) {
        pq.offer(head);
      }
    }

    while(!pq.isEmpty()) {
      ListNode node = pq.poll();
      curr.next = node;
      curr = curr.next;
      if (node.next != null) {
        pq.offer(node.next);
      }
    }

    return dummy.next;
  }

  /**
   * Solution using merge sort. Each time we sort and merge two list.
   * This solution use less space.
   *
   * Time complexity: O(nklogk)
   * Space complexity: O(1)
   */
  public ListNode solutionB(List<ListNode> lists) {
    if (lists == null || lists.isEmpty()) {
      return null;
    }

    int end = lists.size() - 1;
    while (end > 0) {
      int beg = 0;
      while (beg < end) {
        // Each time we merge two list, we store it back to the lists
        lists.set(beg, merge(lists.get(beg), lists.get(end)));
        beg++;
        end--;
      }
    }

    return lists.get(0);
  }

  private ListNode merge(ListNode n1, ListNode n2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while (n1 != null && n2 != null) {
      if (n1.val < n2.val) {
        curr.next = n1;
        n1 = n1.next;
      } else {
        curr.next = n2;
        n2 = n2.next;
      }
      curr = curr.next;
    }

    if (n1 != null) {
      curr.next = n1;
    }
    if (n2 != null) {
      curr.next = n2;
    }

    return dummy.next;
  }
}
