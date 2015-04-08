import datastructure.TreeNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeIteratorTest {
  BinarySearchTreeIterator iterator;
  TreeNode root;
  @Before
  public void setUp() throws Exception {
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node7 = new TreeNode(7);
    TreeNode node8 = new TreeNode(8);
    TreeNode node9 = new TreeNode(9);
    node5.left = node2;
    node2.parent = node5;
    node5.right = node7;
    node7.parent = node5;
    node2.left = node1;
    node1.parent = node2;
    node2.right = node3;
    node3.parent = node2;
    node7.left = node6;
    node6.parent = node7;
    node7.right = node8;
    node8.parent = node7;
    node3.right = node4;
    node4.parent = node3;
    node8.right = node9;
    node9.parent = node8;

    iterator = new BinarySearchTreeIterator(node5);
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testHasNext() throws Exception {
    for (int i = 0; i < 9; i++) {
      assertEquals(true, iterator.hasNext());
      assertEquals(i + 1, iterator.next());
    }
    assertEquals(false, iterator.hasNext());
  }

  @Test
  public void testNext() throws Exception {

  }
}