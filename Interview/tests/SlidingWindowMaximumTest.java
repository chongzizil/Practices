import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SlidingWindowMaximumTest {
  SlidingWindowMaximum slidingWindowMaximum;
  List<Integer> smallArrayRes;
  int[] smallArray;
  int smallArrayW;

  @Before
  public void setUp() throws Exception {
    slidingWindowMaximum = new SlidingWindowMaximum();

    smallArray = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
    smallArrayW = 3;

    smallArrayRes = new ArrayList<>();
    smallArrayRes.add(3);
    smallArrayRes.add(3);
    smallArrayRes.add(5);
    smallArrayRes.add(5);
    smallArrayRes.add(6);
    smallArrayRes.add(7);
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testSolutionA() throws Exception {
    List<Integer> res = slidingWindowMaximum.solutionA(smallArray, smallArrayW);
    assertTrue(res.equals(smallArrayRes));
  }

  @Test
  public void testSolutionB() throws Exception {
    List<Integer> res = slidingWindowMaximum.solutionB(smallArray, smallArrayW);
    assertTrue(res.equals(smallArrayRes));
  }

  @Test
  public void testSolutionC() throws Exception {
    List<Integer> res = slidingWindowMaximum.solutionC(smallArray, smallArrayW);
    assertTrue(res.equals(smallArrayRes));
  }
}