/**
 * Created by youlongli on 4/1/15.
 *
 * Only store integer...
 */
public class SimpleStack {
  private int[] stackArray;
  private int top;

  public SimpleStack() {
    stackArray = new int[16];
    top = 0;
  }

  public void push(int i) {
    if (top == stackArray.length) {
      doubleSize();
    }

    stackArray[top++] = i;
  }

  public int pop() {
    return stackArray[--top];
  }

  public int peek() {
    return stackArray[top - 1];
  }

  public boolean isEmpty() {
    return top == 0;
  }

  private void doubleSize() {
    int[] tmp = new int[stackArray.length * 2];
    for (int i = 0; i < stackArray.length; i++) {
      tmp[i] = stackArray[i];
    }
    stackArray = tmp;
  }
}
