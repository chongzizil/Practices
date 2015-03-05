package com.zil.li.LinkedList;

import com.zil.li.datastructure.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlongli on 2/15/15.
 * <p>
 * Idea: http://www.cnblogs.com/TenosDoIt/p/3387000.html
 */
public class CopyListWithRandomPointer {
  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  public RandomListNode solutionA(RandomListNode head) {
    if (head == null) {
      return head;
    }

    copyNode(head);
    copyRandomNode(head);
    return split(head);
  }

  private void copyNode(RandomListNode head) {
    while (head != null) {
      RandomListNode copy = new RandomListNode(head.label);
      copy.next = head.next;
      head.next = copy;
      head = head.next.next;
    }
  }

  private void copyRandomNode(RandomListNode head) {
    while (head != null) {
      if (head.random != null) {
        head.next.random = head.random.next;
      }
      head = head.next.next;
    }
  }

  private RandomListNode split(RandomListNode head) {
    RandomListNode dummy = new RandomListNode(0);
    dummy.next = head;
    RandomListNode curr = dummy;

    while (curr.next != null) {
      RandomListNode original = curr.next;
      curr.next = curr.next.next;
      curr = curr.next;
      // Note: restore the original node.
      original.next = curr.next;
    }

    return dummy.next;
  }

  /**
   * Use hash map.
   * Time complexity: O(n)
   * Space complexity: O(n)
   */
  public RandomListNode solutionB(RandomListNode head) {
    Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>(); // key: original, value: copy

    copyNode(map, head);
    copyRandomNode(map, head);
    return generateList(map, head);
  }

  private void copyNode(Map<RandomListNode, RandomListNode> map, RandomListNode head) {
    while (head != null) {
      RandomListNode copy = new RandomListNode(head.label);
      map.put(head, copy);
      head = head.next;
    }
  }

  private void copyRandomNode(Map<RandomListNode, RandomListNode> map, RandomListNode head) {
    while (head != null) {
      if (head.random != null) {
        map.get(head).random = map.get(head.random);
      }
      head = head.next;
    }
  }

  private RandomListNode generateList(Map<RandomListNode, RandomListNode> map, RandomListNode head) {
    RandomListNode dummy = new RandomListNode(0);
    RandomListNode curr = dummy;

    while (head != null) {
      curr.next = map.get(head);
      head = head.next;
      curr = curr.next;
    }

    return dummy.next;
  }
}