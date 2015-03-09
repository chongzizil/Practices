package datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youlongli on 3/1/15.
 *
 * https://oj.leetcode.com/problems/lru-cache/
 */
public class LRUCache {
  /**
   * Use a doubly linked list.
   * The least recently used element will be the head of the list.
   */
  private class DoubleListNode {
    public int key;
    public int value;
    public DoubleListNode prev;
    public DoubleListNode next;
    public DoubleListNode(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private int capacity;
  private DoubleListNode head;
  private DoubleListNode tail;
  private Map<Integer, DoubleListNode> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<Integer, DoubleListNode>();
    head = new DoubleListNode(-1, -1);
    tail = new DoubleListNode(-1, -1);
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }

    removeNode(map.get(key));
    appendNode(map.get(key));

    return map.get(key).value;
  }

  public void set(int key, int value) {
    DoubleListNode node = null;
    if (map.containsKey(key)) {
      node = map.get(key);
      node.value = value;
      removeNode(node);
    } else {
      node = new DoubleListNode(key, value);
      map.put(key, node);
    }

    appendNode(node);

    if (map.size() > capacity) {
      map.remove(head.next.key);
      removeNode(head.next);
    }
  }

  private void appendNode(DoubleListNode node) {
    DoubleListNode last = tail.prev;
    node.prev = last;
    last.next = node;
    node.next = tail;
    tail.prev = node;
  }

  private void removeNode(DoubleListNode node) {
    DoubleListNode pre = node.prev;
    DoubleListNode next = node.next;
    pre.next = next;
    next.prev = pre;
  }
}
