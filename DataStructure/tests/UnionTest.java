import org.junit.Test;

import static org.junit.Assert.*;

public class UnionTest {

  @Test
  public void testUnion() throws Exception {
    Union union = new Union(16);

    union.union(1, 2);
    union.union(2, 3);
    union.union(3, 4);

    union.union(5, 6);
    union.union(6, 7);
    union.union(7, 8);

    assertEquals(true, union.isConnected(1, 2));
    assertEquals(false, union.isConnected(1, 8));

    union.union(4, 5);
    assertEquals(true, union.isConnected(1, 8));
  }
}