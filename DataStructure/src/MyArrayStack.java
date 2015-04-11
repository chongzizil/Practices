/**
 * Created by youlongli on 4/1/15.
 *
 * Pro: less wasted space
 * Con: Every operation takes only constant amortized time.
 */
public class MyArrayStack<T> {
  private T[] stackArray;
  private int top;

  public MyArrayStack() {
    stackArray = (T[]) new Object[16];
    top = 0;
  }

  public void push(T i) {
    if (top == stackArray.length) {
      resize(stackArray.length * 2);
    }

    stackArray[top++] = i;
  }

  public T pop() {
    T item = stackArray[--top];
    // Let GC do the job.
    stackArray[top + 1] = null;

    // Shrink to save space
    if (top > 0 && top < stackArray.length / 4) {
      resize(stackArray.length / 2);
    }

    return item;
  }

  public T peek() {
    return stackArray[top - 1];
  }

  public boolean isEmpty() {
    return top == 0;
  }

  private void resize(int size) {
    T[] tmp = (T[]) new Object[size];
    for (int i = 0; i < top; i++) {
      tmp[i] = stackArray[i];
    }
    stackArray = tmp;
  }
}
