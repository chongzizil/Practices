import datastructure.TreeNode;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BSTMinToMaxTest extends TestCase {
  BSTMinToMax bstMinToMax = new BSTMinToMax();
  TreeNode node1;
  TreeNode node2;
  TreeNode node3;
  TreeNode node4;
  TreeNode node5;
  TreeNode node6;
  TreeNode node7;
  TreeNode node8;
  TreeNode node9;

  @Before
  public void setUp() {
    node1 = new TreeNode(1);
    node2 = new TreeNode(2);
    node3 = new TreeNode(3);
    node4 = new TreeNode(4);
    node5 = new TreeNode(5);
    node6 = new TreeNode(6);
    node7 = new TreeNode(7);
    node8 = new TreeNode(8);
    node9 = new TreeNode(9);

    node5.left = node3;
    node5.right = node7;
    node3.left = node2;
    node2.left = node1;
    node3.right = node4;
    node7.left = node6;
    node7.right = node8;
    node8.right = node9;
  }

  @After
  public void tearDown() {

  }

  @Test
  public void testSolution1() throws Exception {
    List<Integer> expect = new ArrayList<>();
    expect.add(3);
    expect.add(4);
    expect.add(5);
    expect.add(6);
    expect.add(7);
    assertEquals(bstMinToMax.solution(node5, 3, 7), expect);
  }

  @Test
  public void testSolution2() throws Exception {
    List<Integer> expect = new ArrayList<>();
    expect.add(1);
    expect.add(2);
    expect.add(3);
    expect.add(4);
    expect.add(5);
    expect.add(6);
    expect.add(7);
    expect.add(8);
    expect.add(9);
    assertEquals(bstMinToMax.solution(node5, 1, 9), expect);
  }

  @Test
  public void testSolution3() throws Exception {
    List<Integer> expect = new ArrayList<>();
    expect.add(3);
    expect.add(4);
    expect.add(5);
    expect.add(6);
    expect.add(7);
    expect.add(8);
    expect.add(9);
    assertEquals(bstMinToMax.solution(node5, 3, 9), expect);
  }
}