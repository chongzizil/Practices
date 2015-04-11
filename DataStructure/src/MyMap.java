/**
 * Created by youlongli on 4/8/15.
 */
public class MyMap<K, V> {
  class Node<K, V> {
    K key;
    V value;
    Node<K, V> next;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  Node<K, V>[] table;
  int size;

  public MyMap() {
    table = new Node[4];
    size = 0;
  }

  public void put(K key, V value) {
    int index = hash(key);

    for (Node<K, V> node = table[index]; node != null; node = node.next) {
      if (key.equals(node.key)) {
        node.value = value;
        return;
      }
    }

    Node<K, V> newNode = new Node<>(key, value);
    newNode.next = table[index];
    table[index] = newNode;
  }

  public V get(K key) {
    int index = hash(key);

    for (Node<K, V> node = table[index]; node != null; node = node.next) {
      if (node.key.equals(key)) return node.value;
    }

    return null;
  }

  private int hash(K key) {
    return (key.hashCode() & 0x7fffffff) % table.length;
  }

  public boolean containsKey(K key) {
    int hash = key.hashCode();
    int index = hash % table.length;
    if (table[index] != null) {
      Node<K, V> node = table[index];
      while (node != null) {
        if (node.key.equals(key)) {
          return true;
        } else {
          node = node.next;
        }
      }
    }
    return false;
  }

  public boolean isEmpty() {
    return size == 0;
  }
}
