import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class MinHeapTest {
  @Test
  public void smallTest() throws Exception {
    MinHeap minHeap = new MinHeap();
    for (int i = 1; i <= 32; i++) {
      minHeap.add(i);
    }

    for (int i = 1; i <= 32; i++) {
      assertEquals(minHeap.poll(), i);
    }
  }

  @Test
  public void mediumRandomTest() throws Exception {
    List<Integer> nums = new ArrayList<>();
    MinHeap minHeap = new MinHeap();
    Random rd = new Random();

    for (int i = 0; i < 1000; i++) {
      int num = rd.nextInt(1000);
      nums.add(num);
      minHeap.add(num);
    }

    Collections.sort(nums);

    for (int num : nums) {
      assertEquals(minHeap.poll(), num);
    }
  }
}