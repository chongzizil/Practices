/**
 * Created by youlongli on 4/10/15.
 *
 * Pro: Every operation takes constant time in the worst case.
 * Con: Use extra time and space to deal with the links.
 */
public class MyListStack<T> {
  private class Node<T> {
    T item;
    Node next;
  }

  private Node<T> first = null;

  public void push(T item) {
    Node<T> oldFirst = first;
    first = new Node<T>();
    first.item = item;
    first.next = oldFirst;
  }

  public T pop() {
    T item = first.item;
    first = first.next;
    return item;
  }

  public T peek() {
    return first.item;
  }

  public boolean isEmpty() {
    return first == null;
  }
}
