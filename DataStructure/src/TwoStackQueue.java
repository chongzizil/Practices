import java.util.Stack;

/**
 * Created by youlongli on 3/8/15.
 */
public class TwoStackQueue<T> {
  Stack<T> stack1;
  Stack<T> stack2;

  TwoStackQueue() {
    stack1 = new Stack<T>();
    stack2 = new Stack<T>();
  }

  public void push(T elem) {
    stack1.push(elem);
  }

  public T pop() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }

    return stack2.pop();
  }

  public T peek() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }

    return stack2.peek();
  }
}
