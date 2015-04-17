/**
 * Created by youlongli on 4/1/15.
 *
 * Pro: less wasted space
 * Con: Every operation takes only constant amortized time.
 */
public class MyArrayStack<E> {
  private E[] array;
  private int size;

  public MyArrayStack() {
    array = (E[]) new Object[16];
  }

  public void push(E elem) {
    if (isFull()) {
      resize(array.length * 2);
    }

    if (needShrink()) {
      resize(array.length / 2);
    }

    array[size++] = elem;
  }

  public E pop() {
    return array[--size];
  }

  public E peek() {
    return array[size - 1];
  }

  public boolean needShrink() {
    return array.length > 16 && ((double)size / (double)array.length) < 0.25;
  }

  public boolean isFull() {
    return size == array.length;
  }

  public void resize(int size) {
    E[] newArray = (E[]) new Object[size];
    for (int i = 0; i < this.size; i++) {
      newArray[i] = array[i];
    }
    array = newArray;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }
}
