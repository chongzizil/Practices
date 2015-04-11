import datastructure.Interval;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IntervalSearchTreeTest {
  IntervalSearchTree intervalSearchTree;
  @Before
  public void setUp() throws Exception {
    intervalSearchTree = new IntervalSearchTree();
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void test() {
    int[] intervalArray = new int[]{/*1*/15, 20, /*2*/10, 30, /*3*/17, 19, /*4*/5, 20, /*5*/12, 15, /*6*/30, 40};
    List<Interval> intervalList = new ArrayList<>();

    for (int i = 0; i < intervalArray.length; i++) {
      intervalList.add(new Interval(intervalArray[i++], intervalArray[i]));
    }

    for (Interval interval : intervalList) {
      intervalSearchTree.insert(interval);
    }

    intervalSearchTree.inorderPrint();

    Interval testInterval1 = new Interval(6, 7);
    assertEquals(true, intervalSearchTree.searchOverlap(testInterval1) != null);
    Interval testInterval2 = new Interval(1, 2);
    assertEquals(false, intervalSearchTree.searchOverlap(testInterval2) != null);
  }
}