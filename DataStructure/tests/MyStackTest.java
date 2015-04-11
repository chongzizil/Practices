import org.junit.Test;

import static org.junit.Assert.*;

public class MyStackTest {

  @Test
  public void testArrayStack() throws Exception {
    MyArrayStack<Integer> stack = new MyArrayStack<>();
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);
    assertEquals(40, (int) stack.pop());
    assertEquals(30, (int) stack.pop());
    assertEquals(20, (int) stack.pop());
    assertEquals(10, (int) stack.pop());
    assertEquals(true, stack.isEmpty());
  }

  @Test
  public void testListArray() throws Exception {
    MyListStack<Integer> stack = new MyListStack<>();
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);
    assertEquals(40, (int) stack.pop());
    assertEquals(30, (int) stack.pop());
    assertEquals(20, (int) stack.pop());
    assertEquals(10, (int) stack.pop());
    assertEquals(true, stack.isEmpty());
  }
}