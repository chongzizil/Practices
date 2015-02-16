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
  public ListNode mergeKLists(List<ListNode> lists) {
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
}
