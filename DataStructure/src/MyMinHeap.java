import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * Created by youlongli on 3/1/15.
 */
public class MyMinHeap<Key extends Comparable<Key>> {
  private Key[] array;
  private int N;

  public MyMinHeap() {
    array = (Key[]) Array.newInstance(Comparable.class, 4);
    N = 0; // No element in index 0.
  }

  public void add(Key num) {
    if (isFull()) {
      resize(array.length * 2);
    }

    array[++N] = num;
    int pos = N;
    while(pos > 1 && array[pos / 2].compareTo(array[pos]) == 1) {
      swap(pos / 2, pos);
      pos = pos / 2;
    }
  }

  public Key poll() {
    Key res = array[1];;
    array[1] = array[N--];
    heapify(1);
    return res;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  private void swim(int pos) {
    while (pos != 1 && less(pos, pos / 2)) {
      swap(pos, pos / 2);
      pos = pos / 2;
    }
  }

  private void heapify(int pos) {
    int left = pos * 2;
    int right = pos * 2 + 1;
    int min = pos;
    if (left <= N && less(left, min)) {
      min = left;
    }
    if (right <= N && less(right, min)) {
      min = right;
    }
    if (min != pos) {
      swap(pos, min);
      heapify(min);
    }
  }

  private boolean less(int p, int q) {
    return array[p].compareTo(array[q]) < 0;
  }

  private void resize(int size) {
    Key[] newArray = (Key[]) Array.newInstance(Comparable.class, size);
    for (int i = 0; i <= N; i++) {
      newArray[i] = array[i];
    }
    array = newArray;
  }

  private boolean isFull() {
    return N == array.length - 1;
  }

  private void swap(int i, int j) {
    Key tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
