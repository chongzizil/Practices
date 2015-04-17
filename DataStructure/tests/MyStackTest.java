import org.junit.Test;

import java.util.Random;
import java.util.Stack;

import static org.junit.Assert.*;

public class MyStackTest {

  @Test
  public void testArrayStack() throws Exception {
    MyArrayStack<Integer> myStack = new MyArrayStack<>();
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < 100000; i++) {
      stack.push(i);
      myStack.push(i);
    }

    assertEquals(100000, myStack.size());

    while (!myStack.isEmpty()) {
      assertEquals(stack.pop(), myStack.pop());
    }

    // Test for shrink...
    for (int i = 0; i < 100000; i++) {
      stack.push(i);
      myStack.push(i);
    }

    assertEquals(100000, myStack.size());

    while (!myStack.isEmpty()) {
      assertEquals(stack.pop(), myStack.pop());
    }

    assertEquals(true, myStack.isEmpty());
  }

  @Test
  public void testListArray() throws Exception {
    MyListStack<Integer> myStack = new MyListStack<>();
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < 100000; i++) {
      stack.push(i);
      myStack.push(i);
    }

    assertEquals(100000, myStack.size());

    while (!myStack.isEmpty()) {
      assertEquals(stack.pop(), myStack.pop());
    }

    assertEquals(true, myStack.isEmpty());
  }
}