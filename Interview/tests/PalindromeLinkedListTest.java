import datastructure.ListNode;
import junit.framework.TestCase;
import static junit.framework.Assert.*;

public class PalindromeLinkedListTest extends TestCase {
  PalindromeLinkedList instance = new PalindromeLinkedList();

  @org.junit.Test
  public void testSolutionAIsPalindrome1() throws Exception {
    ListNode node0 = new ListNode(0);
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(1);
    ListNode node4 = new ListNode(0);
    node0.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    assertEquals(instance.solutionA(node0), true);
  }

  @org.junit.Test
  public void testSolutionAIsPalindrome2() throws Exception {
    ListNode node0 = new ListNode(0);
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(2);
    ListNode node4 = new ListNode(1);
    ListNode node5 = new ListNode(0);
    node0.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    assertEquals(instance.solutionA(node0), true);
  }

  @org.junit.Test
  public void testSolutionANotPalindrome() throws Exception {
    ListNode node0 = new ListNode(0);
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(3);
    ListNode node3 = new ListNode(2);
    ListNode node4 = new ListNode(1);
    ListNode node5 = new ListNode(0);
    node0.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    assertEquals(instance.solutionA(node0), false);
  }

  @org.junit.Test
  public void testSolutionBIsPalindrome1() throws Exception {
    ListNode node0 = new ListNode(0);
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(1);
    ListNode node4 = new ListNode(0);
    node0.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    assertEquals(instance.solutionB(node0), true);
  }

  @org.junit.Test
  public void testSolutionBIsPalindrome2() throws Exception {
    ListNode node0 = new ListNode(0);
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(2);
    ListNode node4 = new ListNode(1);
    ListNode node5 = new ListNode(0);
    node0.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    assertEquals(instance.solutionB(node0), true);
  }

  @org.junit.Test
  public void testSolutionBNotPalindrome() throws Exception {
    ListNode node0 = new ListNode(0);
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(3);
    ListNode node3 = new ListNode(2);
    ListNode node4 = new ListNode(1);
    ListNode node5 = new ListNode(0);
    node0.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    assertEquals(instance.solutionB(node0), false);
  }
}