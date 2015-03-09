import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TwoStackQueueTest {
  Deque<Integer> queue;
  TwoStackQueue<Integer> twoStackQueue;

  @Before
  public void setUp() throws Exception {
    queue = new ArrayDeque<>();
    twoStackQueue = new TwoStackQueue<>();
  }

  @Test
  public void smallTest() throws Exception {
    assertEquals(1, 1);
    for (int i = 0; i < 100; i++) {
      queue.addLast(i);
      twoStackQueue.push(i);

      if (i % 10 == 3) {
        assertEquals(queue.pollFirst(), twoStackQueue.pop());
      } else if (i % 10 == 6) {
        assertEquals(queue.peekFirst(), twoStackQueue.peek());
      }
    }
  }
}