import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FindKthInUnsortedArrayTest {
  FindKthInUnsortedArray test = new FindKthInUnsortedArray();

  @Test
  public void testSolutionA() throws Exception {
    int size = 1000;
    int[] num = new int[size];
    for (int i = 0; i < size; i++) {
      num[i] = i + 1;
    }

    assertEquals(5, test.solutionA(num, 5));
    assertEquals(15, test.solutionA(num, 15));
    assertEquals(115, test.solutionA(num, 115));
    assertEquals(555, test.solutionA(num, 555));
    assertEquals(995, test.solutionA(num, 995));
  }

  @Test
  public void testSolutionB() throws Exception {
    int size = 1000;
    int[] num = new int[size];
    for (int i = 0; i < size; i++) {
      num[i] = i + 1;
    }

//    assertEquals(5, test.solutionB(num, 5));
//    assertEquals(15, test.solutionB(num, 15));
//    assertEquals(115, test.solutionB(num, 115));
//    assertEquals(555, test.solutionB(num, 555));
//    assertEquals(995, test.solutionB(num, 995));
  }
}