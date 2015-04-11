import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class MyMinHeapTest {
  @Test
  public void smallTest() throws Exception {
    MyMinHeap<Integer> minHeap = new MyMinHeap<>();
    for (int i = 1; i <= 32; i++) {
      minHeap.add(i);
    }

    for (int i = 1; i <= 32; i++) {
      assertEquals(i, (int) minHeap.poll());
    }
  }

  @Test
  public void mediumRandomTest() throws Exception {
    List<Integer> nums = new ArrayList<>();
    MyMinHeap<Integer> minHeap = new MyMinHeap<>();
    Random rd = new Random();

    for (int i = 0; i < 10000; i++) {
      int num = rd.nextInt(10000);
      nums.add(num);
      minHeap.add(num);
    }

    Collections.sort(nums);

    for (int num : nums) {
      assertEquals(num, (int) minHeap.poll());
    }
  }
}