import datastructure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by youlongli on 3/3/15.
 *
 * Reverse print the list.
 */
public class ReversePrintLinkedList {
  /**
   * Stack
   */
  public void printA(ListNode head) {
    Deque<ListNode> stack = new ArrayDeque<>();
    while (head != null) {
      stack.push(head);
      head = head.next;
    }

    while (!stack.isEmpty()) {
      System.out.println(stack.pop().val);
    }
  }

  /**
   * Iterative
   */
  public void printB(ListNode head) {
    head = reverse(head);
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }

  private ListNode reverse(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode curr = head;
    while (curr.next != null) {
      ListNode next = curr.next;
      curr.next = next.next;
      next.next = dummy.next;
      dummy.next = next;
    }
    return dummy.next;
  }

  /**
   * Recursive
   */
  public void printC(ListNode head) {
    if (head == null) {
      return;
    }
    printC(head.next);
    System.out.println(head.val);
  }
}
