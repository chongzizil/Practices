package com.zil.li.Tree;

import com.zil.li.datastructure.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiameterOfTreeTest {
  DiameterOfTree diameterOfTree = new DiameterOfTree();

  @Test
  public void testGetDiameter() throws Exception {
    TreeNode node0 = new TreeNode(0);
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node7 = new TreeNode(7);
    TreeNode node8 = new TreeNode(8);
    TreeNode node9 = new TreeNode(9);
    TreeNode node10 = new TreeNode(10);
    TreeNode node11 = new TreeNode(11);
    TreeNode node12 = new TreeNode(12);

    node0.left = node1;
    node0.right = node2;
    node1.left = node3;
    node1.right = node4;
    node4.left = node6;
    node4.right = node7;
    node2.right = node5;
    node5.left = node6;
    node4.right = node7;
    node4.left = node8;
    node6.left = node9;
    node6.right = node10;
    node9.left = node11;
    node9.right = node12;

    assertEquals(diameterOfTree.getDiameter(node0), 9);
  }
}