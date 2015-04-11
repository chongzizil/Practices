import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class MyMapTest {

  @Test
  public void testPut() throws Exception {
    MyMap<String, Integer> map = new MyMap<>();
    map.put("1", 1);
    map.put("2", 2);
    map.put("3", 3);
    map.put("4", 4);
    map.put("5", 5);
    map.put("6", 6);
    map.put("7", 7);

    assertEquals(true, map.containsKey("1"));
    assertEquals(true, map.containsKey("2"));
    assertEquals(true, map.containsKey("7"));
    assertEquals(1, (int) map.get("1"));
    assertEquals(4, (int) map.get("4"));
    assertEquals(7, (int) map.get("7"));
    assertEquals(null, map.get("8"));
    assertEquals(false, map.containsKey("8"));
  }
}