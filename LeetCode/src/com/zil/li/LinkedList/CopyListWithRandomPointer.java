package com.zil.li.LinkedList;

import com.zil.li.datastructure.RandomListNode;

/**
 * Created by youlongli on 2/15/15.
 *
 * Idea: http://www.cnblogs.com/TenosDoIt/p/3387000.html
 */
public class CopyListWithRandomPointer {
  private void copyNext(RandomListNode head) {
    while (head != null) {
      RandomListNode node = new RandomListNode(head.label);
      node.random = head.random; // ?
      node.next = head.next;
      head.next = node;
      head = head.next.next;
    }
  }

  private void copyRandom(RandomListNode head) {
    while (head != null) {
      if (head.random != null) {
        head.next.random = head.random.next;
      }
      head = head.next.next;
    }
  }

  // Remember to restore the original list!!!
  private RandomListNode split(RandomListNode head) {
    RandomListNode dummy = new RandomListNode(0);
    dummy.next = head;
    RandomListNode curr = dummy;
    while (curr.next != null) {
      RandomListNode tmp = curr.next;
      curr.next = curr.next.next;
      curr = curr.next;
      tmp.next = curr.next;
    }

    return dummy.next;
  }

  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) {
      return null;
    }

    copyNext(head);
    copyRandom(head);
    return split(head);
  }
}
