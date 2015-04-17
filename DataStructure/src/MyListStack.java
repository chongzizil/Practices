/**
 * Created by youlongli on 4/10/15.
 *
 * Pro: Every operation takes constant time in the worst case.
 * Con: Use extra time and space to deal with the links.
 */
public class MyListStack<E> {
  private class Node {
    E elem;
    Node next;

    public Node(E elem) {
      this.elem = elem;
    }
  }

  private Node head;
  int size;

  public MyListStack() {
    this.head = null;
    size = 0;
  }

  public void push(E elem) {
    Node node = new Node(elem);
    Node oldHead = head;
    head = node;
    node.next = oldHead;
    size++;
  }

  public E pop() {
    E rst = head.elem;
    head = head.next;
    size--;
    return rst;
  }

  public E peek() {
    return head.elem;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public int size() {
    return size;
  }
}
