import com.sun.javafx.binding.StringFormatter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MyMapTest {

  @Test
  public void testPut() throws Exception {
    MyMap<String, Integer> map = new MyMap<>();
    List<Integer> nums = new ArrayList<>();

    for (int i = 0; i < 1000; i++) {
      nums.add(i);
    }

    for (int num : nums) {
      map.put(String.valueOf(num), num);
    }

    for (int num : nums) {
      assertEquals(true, map.containsKey(String.valueOf(num)));
      assertEquals(num, (int) map.get(String.valueOf(num)));
    }

    assertEquals(false, map.containsKey("10001"));
  }
}