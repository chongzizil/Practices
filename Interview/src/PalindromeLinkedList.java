import datastructure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by youlongli on 3/3/15.
 *
 * Check if a linked list is palindrome. (Value is int.)
 * http://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
 */
public class PalindromeLinkedList {
  /**
   * Use stack.
   * Time: O(n)
   * Space: O(n)
   */
  public boolean solutionA(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    Deque<ListNode> stack = new ArrayDeque<>();
    ListNode curr = head;

    while (curr != null) {
      stack.push(curr);
      curr = curr.next;
    }

    curr = head;
    while (!stack.isEmpty()) {
      if (curr.val != stack.pop().val) {
        return false;
      }
      curr = curr.next;
    }

    return true;
  }

  /**
   * Use reverse.
   */
  public boolean solutionB(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    ListNode mid = getMiddle(head);
    ListNode l = head;
    ListNode r = reverse(mid.next);
    mid.next = null;

    while (l != null && r != null) {
      if (l.val != r.val) {
        return false;
      }
      l = l.next;
      r = r.next;
    }

    return true;
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

  private ListNode getMiddle(ListNode head) {
    if (head == null) {
      return null;
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
