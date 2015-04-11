import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FindKthInUnsortedArrayTest {
  FindKthInUnsortedArray test = new FindKthInUnsortedArray();

  @Test
  public void testSolutionA() throws Exception {
    List<Integer> num = new ArrayList<>();
    for (int i = 1; i <= 1000; i++) {
      num.add(i);
    }

    assertEquals(5, test.solutionA(num, 5));
    assertEquals(15, test.solutionA(num, 15));
    assertEquals(115, test.solutionA(num, 115));
    assertEquals(555, test.solutionA(num, 555));
    assertEquals(995, test.solutionA(num, 995));
  }
}