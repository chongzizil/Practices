import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * Created by youlongli on 3/1/15.
 */
public class MyMinHeap<E extends Comparable<E>> {
  private E[] tree;
  private int size;

  public MyMinHeap() {
    tree = (E[]) Array.newInstance(Comparable.class, 16);
  }

  public void offer(E elem) {
    if (isFull()) {
      resize(tree.length * 2);
    }

    tree[++size] = elem;
    swim(size);
  }

  public E poll() {
    E rst = tree[1];
    tree[1] = tree[size];
    tree[size--] = null;
    heapify(1);
    return rst;
  }

  public E peek() {
    return tree[1];
  }

  private void swim(int pos) {
    while (pos != 1 && tree[pos].compareTo(tree[pos / 2]) < 0) {
      swap(pos, pos / 2);
      pos = pos / 2;
    }
  }

  private void heapify(int pos) {
    int min = pos;
    if (pos * 2 <= size && tree[min].compareTo(tree[pos * 2]) > 0) {
      min = pos * 2;
    }
    if (pos * 2 + 1<= size && tree[min].compareTo(tree[pos * 2 + 1]) > 0) {
      min = pos * 2 + 1;
    }
    if (min != pos) {
      swap(pos, min);
      heapify(min);
    }
  }

  private void resize(int size) {
    E[] newTree = (E[]) Array.newInstance(Comparable.class, size);
    for (int i = 0; i < tree.length; i++) {
      newTree[i] = tree[i];
    }
    tree = newTree;
  }

  private void swap(int i, int j) {
    E tmp = tree[i];
    tree[i] = tree[j];
    tree[j] = tmp;
  }

  private boolean isFull() {
    return size == tree.length - 1;
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }
}
