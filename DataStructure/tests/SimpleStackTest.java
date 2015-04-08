import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleStackTest {

  @Test
  public void testPush() throws Exception {
    SimpleStack stack = new SimpleStack();
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);
    assertEquals(40, stack.pop());
    assertEquals(30, stack.pop());
    assertEquals(20, stack.pop());
    assertEquals(10, stack.pop());
    assertEquals(true, stack.isEmpty());
  }
}