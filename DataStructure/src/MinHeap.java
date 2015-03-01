/**
 * Created by youlongli on 3/1/15.
 */
public class MinHeap {
  private int[] array;
  private int size;

  public MinHeap() {
    array = new int[16];
    size = 0;
  }

  public void add(int num) {
    if (isFull()) {
      doubleSize();
    }

    array[++size] = num;
    int pos = size;
    while(pos > 1 && array[pos / 2] > array[pos]) {
      swap(pos / 2, pos);
      pos = pos / 2;
    }
  }

  public int poll() {
    int res = array[1];;
    array[1] = array[size--];
    heapify(1);
    return res;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  private void heapify(int pos) {
    int left = pos * 2;
    int right = pos * 2 + 1;
    int min = pos;
    if (left <= size && array[left] < array[pos]) {
      min = left;
    }
    if (right <= size && array[right] < array[min]) {
      min = right;
    }
    if (min != pos) {
      swap(pos, min);
      heapify(min);
    }
  }

  private void doubleSize() {
    int[] newArray = new int[size * 2];
    for (int i = 1; i <= size; i++) {
      newArray[i] = array[i];
    }
    array = newArray;
  }

  private boolean isFull() {
    return size == array.length - 1;
  }

  private void swap(int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
