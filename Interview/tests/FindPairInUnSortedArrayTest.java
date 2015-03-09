import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FindPairInUnSortedArrayTest {
  FindPairInUnSortedArray pairInUnSortedArray = new FindPairInUnSortedArray();

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void testSolution() throws Exception {
    int[] test = new int[]{1, 3, 2};
    List<int[]> res = pairInUnSortedArray.solution(test);
    //Todo: ...
  }
}